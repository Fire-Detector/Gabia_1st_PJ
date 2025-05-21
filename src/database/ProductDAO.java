package database;

import frame.Frame_Login;

import static database.SimpleConnectionPool.connectionPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    
    public ProductDAO() {
        connection = connectionPool.getConnection();
    }
    
    public boolean addCart(int product_id) {
        
        CartDAO cartDAO = new CartDAO();
        if (cartDAO.findCartIdByUserId()<0) {
            cartDAO.createCart();
        }
        
        String sql =
                "INSERT INTO cart_has_product (cart_id, product_id)\n" +
                "VALUES (                                          \n" +
                "    (SELECT cart_id FROM cart WHERE user_id = ?), \n" +
                "    ?                                             \n" +
                ");";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Frame_Login.loginUser.getUser_id());
            pstmt.setInt(2, product_id);
            System.out.println("Run SQL: "+pstmt.toString());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 1. Create (Insert)
    public int insertProduct(ProductDTO product) {
        String sql = "INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getManufacturer());
            pstmt.setString(3, product.getSpec());
            pstmt.setString(4, product.getReleaseDate());
            pstmt.setInt(5, product.getPrice());
            pstmt.setInt(6, product.getCategoryId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // 생성된 product_id 반환
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // 실패 시 -1 반환
    }
    
    // 2. Read (Select All)
    public List<ProductDTO> selectAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProductDTO product = mapResultSetToProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    // 3. Read (Select By ID)
    public ProductDTO selectProductById(int productId) {
        String sql = "SELECT * FROM product WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProduct(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // 4. Update
    public boolean updateProduct(ProductDTO product) {
        String sql = "UPDATE product SET product_name=?, manufacturer=?, spec=?, release_date=?, price=?, category_id=? " +
                "WHERE product_id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getManufacturer());
            pstmt.setString(3, product.getSpec());
            pstmt.setString(4, product.getReleaseDate());
            pstmt.setInt(5, product.getPrice());
            pstmt.setInt(6, product.getCategoryId());
            pstmt.setInt(7, product.getProductId());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 5. Delete
    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM product WHERE product_id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 6. ResultSet → ProductDTO 매핑
    private ProductDTO mapResultSetToProduct(ResultSet rs) throws SQLException {
        ProductDTO product = new ProductDTO();
        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setManufacturer(rs.getString("manufacturer"));
        product.setSpec(rs.getString("spec"));
        product.setReleaseDate(rs.getString("release_date"));
        product.setPrice(rs.getInt("price"));
        product.setCategoryId(rs.getInt("category_id"));
        return product;
    }
    
    // 7. 카테고리별 조회 (추가 메소드)
    public List<ProductDTO> selectProductsByCategory(int categoryId) {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE category_id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, categoryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapResultSetToProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    // 연결 종료 (필요 시)
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

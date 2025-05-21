package database;

import frame.Frame_Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.SimpleConnectionPool.connectionPool;

public class CartDAO {
    private Connection connection;
    
    public CartDAO() {
        connection = connectionPool.getConnection();
    }
    
    public boolean createCart() {
        
        String sql = "INSERT INTO cart (create_date, user_id) values(CURDATE(), ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Frame_Login.loginUser.getUser_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 1. user_id로 cart_id 조회
    public int findCartIdByUserId() {
        String sql = "SELECT cart_id FROM cart WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Frame_Login.loginUser.getUser_id());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cart_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // 없으면 -1 반환
    }
    
    // 2. 장바구니 상품 목록 조회
    public List<ProductDTO> getCartProducts() {
        List<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT p.product_id, p.product_name, p.manufacturer, " +
                "p.spec, p.release_date, p.price, p.category_id " +
                "FROM cart c " +
                "JOIN cart_has_product chp ON c.cart_id = chp.cart_id " +
                "JOIN product p ON chp.product_id = p.product_id " +
                "WHERE c.user_id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // 로그인 유저의 ID 가져오기
            String userId = Frame_Login.loginUser.getUser_id();
            pstmt.setString(1, userId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ProductDTO product = mapResultSetToProduct(rs);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    // ResultSet → ProductDTO 매핑
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
    public boolean deleteProductFromCart(int productId) {
        int cartId = findCartIdByUserId();
        String sql = "DELETE FROM cart_has_product WHERE cart_id = ? AND product_id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cartId);
            pstmt.setInt(2, productId);
           int result = pstmt.executeUpdate();
           return result > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }
    
    // 연결 종료
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

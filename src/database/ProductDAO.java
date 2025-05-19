package database;

import static database.SimpleConnectionPool.connectionPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    //아이템 정보 보기: 호재영, 이재준
    public List<ProductDTO> getAllGpus() { // getAllGpus()메소드: GpuDTO객체 리스트를 반환
        List<ProductDTO> list = new ArrayList<>(); // GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성

        try (
                // 3. SQL 실행 & 결과 처리
                PreparedStatement pstmt = connectionPool.getConnection().prepareStatement("SELECT * FROM GPU"); // SQL 실행을 준비하는 PreparedStatement
                // 생성 ("GPU 테이블 전체 조회" 쿼리 준비)
                ResultSet rs = pstmt.executeQuery(); // 결과는 rs (ResultSet)에 담김
        ) {
            // 4. 결과를 GpuDTO 객체로 변환
            while (rs.next()) {
                int id = rs.getInt("productID");
                String name = rs.getString("name");
                String perf = rs.getString("performance");
                int price = rs.getInt("price");

                ProductDTO gpu = new ProductDTO(id, name, perf, price);// DTO로 포장
                list.add(gpu);// 리스트에 넣기
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5. 리스트 반환
        return list;
    }// getAllGpus()


}

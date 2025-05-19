package DataBaseJob;

import java.sql.*;           // DB 연결, 쿼리, 결과 처리 등
import java.util.ArrayList; // 리스트 만들기
import java.util.List;      // 리스트 타입을 다루기 위한 인터페이스

//DAO (데이터 접근 객체) -> DB에 직접 접근하는 객체
public class UserDAO {

    // 1. DB 연결용 메서드(매번 DB 연결하는 코드 중복 방지)
    private static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 로딩
        return DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe", "member", "12345"
        );
    }

    // 2. GPU 전체 목록 가져오기
    public static ArrayList<UserDTO> getAllUser() { //getAllGpus()메소드: GpuDTO객체 리스트를 반환
        ArrayList<UserDTO> list = new ArrayList<>(); //GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성

        try (
        	//3. SQL 실행 & 결과 처리
            Connection conn = getConnection(); //오라클 DB와 연결된 Connection 객체 생성
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usertbl"); //SQL 실행을 준비하는 PreparedStatement 생성 ("GPU 테이블 전체 조회" 쿼리 준비)
            ResultSet rs = pstmt.executeQuery(); //결과는 rs (ResultSet)에 담김
        ) {
        	//4. 결과를 GpuDTO 객체로 변환
            while (rs.next()) {
                String UserId = rs.getString("gender");
                String UserName = rs.getString("name");
                String UserPhone = rs.getString("phone");

                UserDTO User = new UserDTO(UserId, UserName, UserPhone);// DTO로 포장
                list.add(User);// 리스트에 넣기
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5. 리스트 반환
        return list;
    }//getAllGpus()
    
}//c
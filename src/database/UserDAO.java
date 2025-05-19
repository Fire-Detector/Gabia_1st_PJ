package database;

import static database.SimpleConnectionPool.connectionPool;

import java.sql.*;           // DB 연결, 쿼리, 결과 처리 등
import java.util.ArrayList; // 리스트 만들기
import java.util.List;


//DAO (데이터 접근 객체) -> DB에 직접 접근하는 객체
public class UserDAO {

    // 1. DB 연결용 메서드(매번 DB 연결하는 코드 중복 방지)

    // 로그인 파트: 이재준
    public boolean login(String userid, String inputPw) {
        boolean result = false;
        Password_01 userDto = null;

        try {
            String sql = "SELECT member_id ,password FROM usertbl WHERE member_id=?";
            PreparedStatement pstmt = connectionPool.getConnection().prepareStatement(sql);
            pstmt.setString(1, userid);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userDto = new Password_01();
                userDto.setUserid(rs.getString("member_id"));
                userDto.setPassword(rs.getString("password"));

                if (userDto.getPassword().equals(inputPw)) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    //마이페이지 창: 나세종, 호재영, 이재준
    public UserDTO getMyPage(String userId) {
        final String SQL = """
            SELECT user_id, user_name, user_phone 
            FROM user_tbl 
            WHERE customer_id = ?""";

        try (Connection conn = connectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next()
                        ? new UserDTO(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_phone")
                )
                        : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("마이페이지 조회 실패", e);
        }
    }

    // 아이디 중복 확인
    public boolean isUserIdExist(String userId) {
        final String SQL = "SELECT 1 FROM usertbl WHERE member_id = ?";

        try (Connection conn = connectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("아이디 확인 실패", e);
        }
    }

    // 2. GPU 전체 목록 가져오기
    public static ArrayList<UserDTO> getAllUser() { //getAllGpus()메소드: GpuDTO객체 리스트를 반환
        ArrayList<UserDTO> list = new ArrayList<>(); //GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성

        try (
        	//3. SQL 실행 & 결과 처리
            Connection conn = connectionPool.getConnection();
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
    // 로그인 체크: 호재영
    public boolean IdCheck(String user_id){
        String sql = "SELECT userid usertbl Values usertbl = ?";

        return false;
    }

    public boolean isValidPassword(String pw) {
        if (pw.length() < 8)
            return false;

        boolean hasLetter = pw.matches(".*[a-zA-Z].*");
        boolean hasDigit = pw.matches(".*\\d.*");
        boolean hasSpecial = pw.matches(".*[!@#$%^&*()].*");

        return hasLetter && hasDigit && hasSpecial;

    }

    //아이디 중복확인 : 김정연
    public boolean IdCheck1(String userid ){

        boolean result = false;

        try {
            String sql = "SELECT member_id FROM usertbl WHERE member_id=?";
            PreparedStatement pstmt = connectionPool.getConnection().prepareStatement(sql);
            pstmt.setString(1, userid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                javax.swing.JOptionPane.showConfirmDialog(null, "사용중인 아이디 입니다", "중복확인",javax.swing.JOptionPane.WARNING_MESSAGE);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}//c
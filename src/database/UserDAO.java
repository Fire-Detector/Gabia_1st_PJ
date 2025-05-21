package database;

import static database.SimpleConnectionPool.connectionPool;

import java.sql.*;           // DB 연결, 쿼리, 결과 처리 등
import java.util.ArrayList; // 리스트 만들기
import javax.swing.JOptionPane;


//DAO (데이터 접근 객체) -> DB에 직접 접근하는 객체
public class UserDAO {
	private Connection conn;
	public UserDAO() {
        try {
            conn = connectionPool.getConnection();
            System.out.println("UserDAO: DB 연결 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    // 1. DB 연결용 메서드(매번 DB 연결하는 코드 중복 방지)
    
    //마이페이지 창: 나세종, 호재영, 이재준
   /*  public UserDTO getMyPage(String userId) {
        final String SQL = """
            SELECT userid, name, phone
            FROM usertbl
            WHERE userid = ?""";

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
*/
    // 2. 유저 가져오기
//    public static UserDTO getMyPage(String user_id) throws SQLException { //getAllGpus()메소드: GpuDTO객체 리스트를 반환
//        ArrayList<UserDTO> list = new ArrayList<>(); //GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성
//        String sql = "SELECT * FROM user where userid = ?";
//        Connection conn = connectionPool.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, user_id);
//        UserDTO user = null;
//
//        try (
//                //3. SQL 실행 & 결과 처리
//                ResultSet rs = pstmt.executeQuery() //결과는 rs (ResultSet)에 담김
//        ) {
//            if (rs.next()) {
//
//                user = new UserDTO(rs.getString("user_id"), rs.getString("user_password"), rs.getString("user_phone"), rs.getString("user_gender"));
//                // 결과가 존재함 (로그인 성공)
//            } else {
//                System.out.println("rs.next() is false");
//                return null;
//                // 결과 없음 (로그인 실패)
//            }
//            //4. 결과를 GpuDTO 객체로 변환
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return user;
//
//    }//getAllGpus()
    
    // 2. 유저 전체 목록 가져오기
    public static ArrayList<UserDTO> getAllUser() { //getAllGpus()메소드: GpuDTO객체 리스트를 반환
        ArrayList<UserDTO> list = new ArrayList<>(); //GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성
        
        try (
                //3. SQL 실행 & 결과 처리
                Connection conn = connectionPool.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user"); //SQL 실행을 준비하는 PreparedStatement 생성 ("GPU 테이블 전체 조회" 쿼리 준비)
                ResultSet rs = pstmt.executeQuery() //결과는 rs (ResultSet)에 담김
        ) {
            //4. 결과를 GpuDTO 객체로 변환
            while (rs.next()) {
                String UserId = rs.getString("userid");
                String UserName = rs.getString("phone");
                String UserGender = rs.getString("gender");
                
                UserDTO user = new UserDTO(rs.getString("user_id"), rs.getString("user_password"), rs.getString("user_phone"), rs.getString("user_gender"));
                list.add(user);// 리스트에 넣기
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //5. 리스트 반환
        return list;
    }//getAllGpus()
    
    // 로그인 파트: 이재준
    public UserDTO login(UserDTO user) {
        
        try {
            String sql = "SELECT * FROM user WHERE user_id = ?";
            Connection conn = connectionPool.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_id());
            ResultSet rs = pstmt.executeQuery();
            System.out.println("UserDAO.login: rsFirst: " + rs);
            rs.next();
            System.out.println("UserDAO.login: rsNext: " + rs);
            if (user.checkPW(rs.getString("user_password"))) {
                user.setUser_phone(rs.getString("user_phone"));
                user.setUser_gender(rs.getString("user_gender"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean register(String user_id, String user_password, String user_phone, String user_gender) {
        int result = 0;
        try {
            // SQL 준비
            String sql = "INSERT INTO user (user_id, user_password, user_phone, user_gender) VALUES (?, ?, ?, ?)";
            Connection conn = connectionPool.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // ? 에 값 넣기
            pstmt.setString(1, user_id);
            pstmt.setString(2, user_password);
            pstmt.setString(3, user_phone);
            pstmt.setString(4, user_gender);
            
            result = pstmt.executeUpdate();
            
            // 자원 정리
            pstmt.close();
            conn.close();
            connectionPool.releaseConnection(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result == 1;
    }
    
    // 아이디 중복 확인
    public boolean isUserIdExist(String userId) {
        final String SQL = "SELECT * FROM user WHERE user_id = ?";
        
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
    
    public boolean isValidPassword(String pw) {
        if (pw.length() < 8)
            return false;
        
        boolean hasLetter = pw.matches(".*[a-zA-Z].*");
        boolean hasDigit = pw.matches(".*\\d.*");
        boolean hasSpecial = pw.matches(".*[!@#$%^&*()].*");
        
        return hasLetter && hasDigit && hasSpecial;
        
    }
    public boolean deleteUser(String userId) {
        try (Connection conn = connectionPool.getConnection()) {

            // cart 먼저 삭제
            String deleteCartSQL = "DELETE FROM cart WHERE user_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteCartSQL)) {
                pstmt.setString(1, userId);
                pstmt.executeUpdate();
            }
            // user 삭제
            String deleteUserSQL = "DELETE FROM user WHERE user_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteUserSQL)) {
                pstmt.setString(1, userId);
                return pstmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //아이디 중복확인 : 김정연
    public boolean IdCheck1(String userid) {
        
        boolean result = false;
        
        try {
            String sql = "SELECT user_id FROM user WHERE user_id=?";
            PreparedStatement pstmt = connectionPool.getConnection().prepareStatement(sql);
            pstmt.setString(1, userid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                javax.swing.JOptionPane.showConfirmDialog(null, "사용중인 아이디 입니다", "중복확인", javax.swing.JOptionPane.WARNING_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
        
    }
}//c
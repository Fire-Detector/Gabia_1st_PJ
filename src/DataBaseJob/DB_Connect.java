/*
 * 수정사항:
 * 1. password_02 부분 DB_Connect 부분으로 메서드 이동
 * 2. desk_02 부분 DB_Connect 부분으로 메서드 이동
 * 3. password_02 부분 메서드 이동(로그인 기능)
 * 4. 각각의 메서드에서 데이터 베이스 연동이기에 데이터베이스 연동 해제(최초 데이터 베이스 연동만 하면 됨, 연동 해제는 나중에)
 * 5. 기존 리스트 형태에서 리스트 형태에서 값을 꺼내오는 형식으로 변경
 * 6. 나세종 pc에서 테스트 불가하기에 테스트 필요
 * 7. Disk02 부분, ProductDTO 파트 이용하여 수정 필요
 * 기본적인 수정은 대략 완료 다만 개인 코드에 대한 설명이 필요
 */

 /*
  * 권고사항:
  1. 데이터베이스 사용할때는 메서드는 DB_Connection에 구현 필요
  2. 각 코드가 비슷할 경우 최대한 남의 것 사용하기
  3. 푸쉬의 경우 혹시나 잘못하지 않았나 다시 확인하기
  4. Frame폴더에는 Frame만 넣어두기
  5. 커밋 할 경우 메시지 변경사항 짧게나마 넣어두기
  6. 데이터베이스 사용할 때마다 connect 하는데 connect는 한번만 선언하고 다 끝나고 종료여서 login, register쪽에만 선언함
  */
/*
 * 남은 기본 기능:
 * 1. 마이페이지 (쿼리 부분 작성 완료)
 * 2. 회원가입 (쿼리는 작성 완료)
 * 3. 로그인 체크 (옆에서 하는 중)
 */
package DataBaseJob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Connect {
	private String DB_Driver = null;
	private String DB_Url= null;
	private String DB_Username= null;
	private String DB_Password= null;
	private Connection conn= null;


	//데이터 베이스 연동: 전원
	public void getConnection() {
		this.DB_Driver = "oracle.jdbc.OracleDriver";
		this.DB_Url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.DB_Username = "member";
		this.DB_Password = "12345";
		try {

			Class.forName(DB_Driver);
			// 3. Connection
			conn = DriverManager.getConnection(DB_Url, DB_Username, DB_Password); // 이 url로 사용자의 아이디와 패스워드를 가지고 연결 한다!
			System.out.println("DB 연결 성공: " + DB_Username);
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e1) {
			System.out.println("db 연결 실패");
			e1.printStackTrace();
		}
	}

// 로그인 파트: 이재준
	public boolean login(String userid, String inputPw) {
		boolean result = false;
		Password_01 userDto = null;

		try {
			String sql = "SELECT member_id ,password FROM usertbl WHERE member_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
	public List<UserDTO> My_Page(String User_id) throws SQLException {
		String sql = "SELECT user_id, user_phone, user_adress from user_tbl where customer_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<>();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, User_id);

		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = pstmt.executeQuery();
					while (rs.next()) {
				String id = rs.getString("User_id");
				String name = rs.getString("User_name");
				String phone = rs.getString("User_Phone");


				UserDTO info = new UserDTO(id, name, phone);// DTO로 포장
				list.add(info);// 리스트에 넣기
			}

		return list;
	}

	//아이템 정보 보기: 호재영, 이재준
	public List<ProductDTO> getAllGpus() { // getAllGpus()메소드: GpuDTO객체 리스트를 반환
		List<ProductDTO> list = new ArrayList<>(); // GpuDTO라는 객체들을 담을 수 있는 비어있는 리스트 생성

		try (
				// 3. SQL 실행 & 결과 처리
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM GPU"); // SQL 실행을 준비하는 PreparedStatement
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
         PreparedStatement pstmt = conn.prepareStatement(sql);
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
	
}

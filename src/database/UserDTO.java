/*
 * 제작 인원: 호재영, 이재준
 */
package database;


public class UserDTO {
    
    private String User_id;
    private String User_password;
    private String User_phone;
    private String User_gender;
    
    @Override
    public String toString() {
        return "UserDTO{" +
                "User_id='" + User_id + '\'' +
                ", User_password='" + User_password + '\'' +
                ", User_phone='" + User_phone + '\'' +
                ", User_gender='" + User_gender + '\'' +
                '}';
    }
    
    // 생성자
    //this.XXX는 현재 객체의 필드를 가리키고, 오른쪽 XXX는 파라미터
    public UserDTO(String User_id, String User_password, String User_phone, String user_gender) {
        this.User_id = User_id;
        this.User_password = User_password;
        this.User_phone = User_phone;
        this.User_gender = user_gender;
    }
    
    public String getUser_id() {
        return User_id;
    }
    
    public void setUser_id(String user_id) {
        User_id = user_id;
    }
    
    public String getUser_password() {
        return User_password;
    }
    
    public void setUser_password(String user_password) {
        User_password = user_password;
    }
    
    public String getUser_phone() {
        return User_phone;
    }
    
    public void setUser_phone(String user_phone) {
        User_phone = user_phone;
    }
    
    public String getUser_gender() {
        return User_gender;
    }
    
    public void setUser_gender(String user_gender) {
        User_gender = user_gender;
    }
    
    public boolean checkPW (String user_password) {
        return this.User_password.equals(user_password);
    }

}

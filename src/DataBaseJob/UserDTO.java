/*
 * 제작 인원: 나세종, 호재영, 이재준
 */
package DataBaseJob;


import java.util.List;

public class UserDTO {
    
    private String User_id;
    private String User_name;
    private String User_phone;
    

    // 생성자
    //this.XXX는 현재 객체의 필드를 가리키고, 오른쪽 XXX는 파라미터
    public UserDTO(String User_id, String User_name, String User_phone) {
        this.User_id = User_id;
        this.User_name = User_name;
        this.User_phone = User_phone;
    }

    // getter(외부에서 GPU 객체의 정보를 꺼낼 때 사용)
    public String getUser_Id() { return User_id; }
    public String getName() { return User_name; }
    public String getUser_Phone() { return User_phone; }

}

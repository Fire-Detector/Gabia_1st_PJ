import database.SimpleConnectionPool;
import frame.Frame_Login;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleConnectionPool.connectionPool = new SimpleConnectionPool();
        System.out.println(SimpleConnectionPool.connectionPool.getConnection());
        Frame_Login LoginFrame = new Frame_Login();
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setVisible(true);
        
    }
}

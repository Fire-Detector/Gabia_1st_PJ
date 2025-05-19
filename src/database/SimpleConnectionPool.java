package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class SimpleConnectionPool {
    public static SimpleConnectionPool connectionPool;
    private final LinkedList<Connection> pool = new LinkedList<>();
    private final int MAX_POOL_SIZE = 10;

    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String user = "member";
    private final String password = "12345";

    public SimpleConnectionPool() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            pool.add(createNewConnection());
        }
    }

    private Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 커넥션 빌려주기
    public synchronized Connection getConnection() {
        try {
            if (pool.isEmpty()) {
                // 풀에 없으면 새로 생성 (풀 최대치 제한 가능)
                return createNewConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pool.removeFirst();
    }

    // 커넥션 반환받기
    public synchronized void releaseConnection(Connection conn) {
        if (conn != null) {
            pool.addLast(conn);
        }
    }
}

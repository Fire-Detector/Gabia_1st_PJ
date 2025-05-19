package frame;

import static database.SimpleConnectionPool.connectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MainBoard_02 {
    
    private String obid;
    private String mbid;
    private String mbdata;
    private String price;

    public MainBoard_02(String obid, String mbid, String mbdata, String price) {
        this.obid = obid;
        this.mbid = mbid;
        this.mbdata = mbdata;
        this.price = price;
    }

    public String getobid() { return obid; }
    public String getmbid() { return mbid; }
    public String getmbdata() { return mbdata; }
    public String getPrice() { return price; }

     // toString() 오버라이딩 - 출력용
    @Override
    public String toString() {
        return "MainBoard [obid=" + obid + ", mbid=" + mbid + ", mbdata=" + mbdata + ", price=" + price + "]";
    }

    public static ArrayList<MainBoard_02> getMainBoardList() {
        ArrayList<MainBoard_02> list = new ArrayList<>();
        try {
            Connection conn = connectionPool.getConnection();
            
            String sql = "SELECT * FROM mainboard";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String obid = rs.getString("obid");
                String mbid = rs.getString("mbid");
                String mbdata = rs.getString("mbdata");
                String price = rs.getString("price");

                MainBoard_02 MainBoard = new MainBoard_02(obid, mbid, mbdata, price);
                list.add(MainBoard);
            }

            System.out.println(list);
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

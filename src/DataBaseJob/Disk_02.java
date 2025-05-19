package DataBaseJob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Disk_02 {
    
    private String prodctid;
    private String diskid;
    private String diskdata;
    private String price;

    public Disk_02(String prodctid, String diskid, String diskdata, String price) {
        this.prodctid = prodctid;
        this.diskid = diskid;
        this.diskdata = diskdata;
        this.price = price;
    }

    public String getProdctid() { return prodctid; }
    public String getDiskid() { return diskid; }
    public String getDiskdata() { return diskdata; }
    public String getPrice() { return price; }

    public static ArrayList<Disk_02> getDiskList() {
        ArrayList<Disk_02> list = new ArrayList<>();
        try {
        	Connection con = DriverManager.getConnection(
        	"jdbc:oracle:thin:@localhost:1521:xe", "admin", "12345");
            
            String sql = "SELECT * FROM disk";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
 
            while (rs.next()) {
                String prodctid = rs.getString("prodctid");
                String diskid = rs.getString("diskid");
                String diskdata = rs.getString("diskdata");
                String price = rs.getString("price");

                Disk_02 disk = new Disk_02(prodctid, diskid, diskdata, price);
                list.add(disk);
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}


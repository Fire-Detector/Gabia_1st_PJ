package Frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CPU_DB {

    private String cpuprodctid;
    private String cpuid;
    private String cpuprice;
    private String cpudata;

    public CPU_DB(String cpuid, String cpuprice, String cpudata, String cpuprodctid){
        this.cpuid = cpuid;
        this.cpuprice = cpuprice;
        this.cpudata = cpudata;
        this.cpuprodctid = cpuprodctid;
    }
        public String getcpuid(){ return cpuid; }
        public String getcpuprice(){ return cpuprice; }
        public String getcpudata(){ return cpudata; }
        public String getcpuprodctid(){ return cpuprodctid; }


    public static ArrayList<CPU_DB> getCpulist(){
        ArrayList<CPU_DB> list = new ArrayList<>();
        try {
        	Connection conn = DriverManager.getConnection(
        	"jdbc:oracle:thin:@localhost:1521:xe", "admin", "12345");
            
            String sql = "SELECT * FROM product";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
 
            while (rs.next()) {
                String cpuid = rs.getString("cpuid");
                String cpuprice = rs.getString("cpuprice");
                String cpudata = rs.getString("cpudata");
                String cpuprodctid = rs.getString("cpuprodctid");

                CPU_DB cpu = new CPU_DB(cpuid, cpuprice, cpudata, cpuprodctid);
                list.add(cpu);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}

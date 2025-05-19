package DataBaseJob;

public class Disk_01 {
    
    private String prodctid;
    private String diskid;
    private String diskdata;
    private String price;

    public Disk_01(String prodctid, String diskid, String diskdata, String price) {
        this.prodctid = prodctid;
        this.diskid = diskid;
        this.diskdata = diskdata;
        this.price = price;
    }

    public String getProdctid() { return prodctid; }
    public String getDiskid() { return diskid; }
    public String getDiskdata() { return diskdata; }
    public String getPrice() { return price; }
}
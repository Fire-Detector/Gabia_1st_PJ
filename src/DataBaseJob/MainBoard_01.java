package DataBaseJob;

public class MainBoard_01 {

    private String obid;
    private String mbid;
    private String mbdata;
    private String price;

    public MainBoard_01(String obid, String mbid, String mbdata, String price) {
        this.obid = obid;
        this.mbid = mbid;
        this.mbdata = mbdata;
        this.price = price;
    }

    public String getobid() { return obid; }
    public String getmbid() { return mbid; }
    public String getmbdata() { return mbdata; }
    public String getPrice() { return price; }
}

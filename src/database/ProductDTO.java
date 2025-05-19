/*
 * 제작 인원: 호재영, 이재준
 */
package database;

//DTO (데이터 전달 객체) -> 하나의 GPU정보를 담을 객체 설계도. DB테이블의 행 1개 = GPU객체 1개
public class ProductDTO {
    private int productId;
    private String productName;
    private String manufacturer;
    private String spec;
    private String releaseDate;
    private int price;
    private int categoryId;
    
    // 기본 생성자
    public ProductDTO() {}
    
    // 모든 필드를 받는 생성자
    public ProductDTO(int productId, String productName, String manufacturer, String spec,
                      String releaseDate, int price, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.spec = spec;
        this.releaseDate = releaseDate;
        this.price = price;
        this.categoryId = categoryId;
    }
    
    // Getter & Setter
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public String getSpec() {
        return spec;
    }
    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", spec='" + spec + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}

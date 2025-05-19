/*
 * 제작 인원: 호재영, 이재준
 */
package DataBaseJob;

//DTO (데이터 전달 객체) -> 하나의 GPU정보를 담을 객체 설계도. DB테이블의 행 1개 = GPU객체 1개
public class ProductDTO {
	//필드 선언부
	//private으로 선언하여 외부에서 직접 건드리지X, getter로만 접근(캡슐화)
    private int productID;
    private String name;
    private String performance;
    private int price;

    // 생성자
    //this.XXX는 현재 객체의 필드를 가리키고, 오른쪽 XXX는 파라미터
    public ProductDTO(int productID, String name, String performance, int price) {
        this.productID = productID;
        this.name = name;
        this.performance = performance;
        this.price = price;
    }

    // getter(외부에서 GPU 객체의 정보를 꺼낼 때 사용)
    public int getProductID() { return productID; }
    public String getName() { return name; }
    public String getPerformance() { return performance; }
    public int getPrice() { return price; }
}

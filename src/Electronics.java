import java.io.Serializable;

public class Electronics extends Product implements Serializable {
    private static long serialVersionUTD=1l;
    private String brand;
    private int  warrantyPeriod;

    public Electronics(String productId, String productName,int numItem,double productPrice,String brand, int warrantyPeriod){
        super(productId, productName, numItem, productPrice);
        this.brand= brand;
        this.warrantyPeriod= warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public  int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void displayAllInfo() {
        System.out.println("Electronic Product - Id : " + getProductId() + " ,Name : " + getProductName() +" ,Price : "+ getProductPrice() +" ,Brand : " + brand + " ,Warranty: " + warrantyPeriod + " months, "+"Available no.items :"+getNumItem());

    }

    @Override
    public String toString() {
        return getProductId() +" / " + getProductName() +" / " + "Electronics"+" / " + getProductPrice()+ " / "+ brand +" , " +warrantyPeriod +" warranty " + "  \n ";
    }
}
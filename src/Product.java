import java.io.*;

abstract class Product implements Serializable {//used Serializable for save objects


     ate Stprivring productId  ;
    private String productName;
    private int numItem;
    private double productPrice;

    public Product(String productId, String productName,int numItem,double productPrice){//product constructor
        this.productId=productId;
        this.productName=productName;
        this.numItem=numItem;
        this.productPrice=productPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductId(){
        return  productId;
    }

    public String getProductName() {
        return productName;
    }
    public int getNumItem() {
        return numItem;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public abstract void displayAllInfo();

}

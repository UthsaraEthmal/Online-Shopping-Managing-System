import java.io.Serializable;

public class Clothing extends Product implements Serializable {



        private String size;
        private String colour;

        public Clothing(String productId, String productName, int numItem, double productPrice,String size, String colour ) {
            super(productId, productName, numItem, productPrice);
            this.size = size;
            this.colour = colour;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSize() {
            return size;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public String getColour() {
            return colour;
        }

        public void displayAllInfo() {
            System.out.println("Clothing Product   - ID : " + getProductId() + " ,Name : " + getProductName()+ " ,Price : "+ getProductPrice() +" ,Size  : " + size +  ", Colour  : " + colour +" Available no.Items :"+getNumItem());
        }

        @Override
        public String toString() {
            return  getProductId() + " / " + getProductName() + " / " +"Clothing"+ " / "+getProductPrice()+ " / " + size +" , "+ colour + " /\n ";
        }
    }



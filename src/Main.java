public class Main {
    public static void main(String[] args) {
        ShoppingManager sys =new WestminsterShoppingManager();

        boolean exit = false;

        while (!exit){
            exit = sys.MENU();
        }


    }
}

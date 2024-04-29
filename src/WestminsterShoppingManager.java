import java.io.IOException;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;

public class WestminsterShoppingManager implements ShoppingManager {

    static Scanner sc = new Scanner(System.in);//scanner object
    static ArrayList<Product> productsList=new ArrayList<>(50);//Products array list declaration
    static ArrayList<User>usersList=new ArrayList<>();//users array list declaration
    public ArrayList<Product> getProductList() {//Returning the list
        return productsList;
    }

    String productId;
    String productName;
   static double productPrice;
    static int numItem;
    static String size;
    static String password;
    static String userName;
    static String enteredUsername;
    static String enteredPassword;
    static int warrantyPeriod ;


 public void userRegister(){// For user registration
     validateUserName();// calling for the username validation method
     passwordValide();// calling for the user password validation method
     System.out.println("Your details successfully saved");
     System.out.println("                 ****");
     System.out.println("   ---------------------------------");
     System.out.println(" ");
     System.out.println("Dear  customer;\n\tYour login username :"+userName+" \n\tYour login Password :"+password);
     System.out.println(" ");
     System.out.println("   ---------------------------------");
     System.out.println("                 ****");
     User u = new User(userName,password);//User Constructor , "u"  = new object
     usersList.add(u);//adding new object to the "usersList"

     try (FileOutputStream fos = new FileOutputStream("User_List.txt");//object saving and file name
          ObjectOutputStream oos = new ObjectOutputStream(fos)) {

         oos.writeObject(usersList);
         System.out.println("***Thank You!***");
         oos.close();
         fos.close();

     } catch (IOException e) {
         System.err.println("Error saving Details\n " );
         e.printStackTrace();  // print the stack trace for debugging
     } }

    public void userLogin() {// user login method
        System.out.print("Enter your username: ");
        enteredUsername = sc.next();
        System.out.print("Enter your password: ");
        enteredPassword = sc.next();

        boolean logIn = false;

        for (User user : usersList) {//using the list
            if (enteredUsername.equals(user.getUserName()) && enteredPassword.equals(user.getPassword())) {//checking the entered details and saved details
                System.out.println("Login successful. You can now proceed with the shopping cart");
                System.out.println("\n       **********");
                System.out.println("Click, shop, joy won't stop!");
                System.out.println("       **********\n");
                OpenCustomerMenu();//opening the GUI
                logIn = true;
                break;
            }

        }

        if (!logIn) {
            System.err.println("Invalid username or password. Please try again.\n  ");
        }
    }





    private static void loadObjuser() {//loading the user list file
        try (FileInputStream fis = new FileInputStream("User_List.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            usersList = (ArrayList<User>) ois.readObject();
            //for (Product product : productsList) {
            // System.out.println(product);
            //  }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading User objects " );
            e.printStackTrace();  // print the stack trace for debugging
        }
    }

    public void validateUserName() {//validating the username,the username must be unique
        System.out.println("Please enter Username :");
        userName = sc.next();
        for (int i = 0; i <usersList.size(); i++) {
          User u = usersList.get(i);

            while (u.getUserName().equals(userName)) {//the username must be unique
                System.out.println("This " + userName + " user name already used.\n Please re enter a valid User name :");
                userName = sc.next();
                System.out.println(" ");
                break;
            }

        }
    }
    public void passwordValide(){//validating the password
        while (true) {
        System.out.println("Please enter Password :");
         password = sc.next();
        if(password.length() >= 5){//the condition of the correct password
            break;
        } else {
            System.err.println("Password is invalid. It should contain at least 5 characters.");
          //  password = sc.next();

    }
        }
    }

    public void addProducts(){//add Electronic and Clothing products to the system method
        boolean quit = false;
        System.out.println(" 'Add Products'");

        while (!quit) {
            try {

                System.out.println("----------------------------------------------------");
                System.out.println("Press 1 if you want to add an 'electronic' product");
                System.out.println("Press 2 if you want to add a 'clothing' product");
                System.out.println("Press 0 if you want to go back to the main");
                System.out.println("----------------------------------------------------");
                System.out.println(" ");
                int option2 = sc.nextInt();
                sc.nextLine();

                switch (option2) {

                    case 1://Adding Electronics to the system
                        validateID();//calling for the product ID validation method
                        System.out.println("Please enter the product name :");
                        productName = sc.nextLine();
                        checkNumItem();//calling for the check number of items validation method
                        checkProductPrice();//calling for the product price validation method
                        System.out.println("Please enter the  product brand :");
                        String brand = sc.next();
                        checkWarrantyMonths();//calling for the product warranty validation method

                        Electronics e = new Electronics(productId, productName, numItem, productPrice,brand, warrantyPeriod);//Electronic Constructor
                        addProduct(e);//Adding e(new electronic object) to the product;Using methode
                        System.out.println("\nThe product was successfully added to the system. \n");
                        break;

                    case 2://Adding Clothing to the system

                        validateID();//calling for the product ID validation method
                        System.out.println("Please enter the product name :");
                        productName = sc.nextLine();
                        checkNumItem();//calling for the check number of items validation method
                        checkProductPrice();//calling for the product price validation method
                        checkProductSize();//calling for the product size validation method
                        System.out.println("Please enter the product colour :");
                        String colour= sc.next();

                        Clothing c = new Clothing(productId,productName,numItem,productPrice,size,colour);//Clothing Constructor
                        addProduct(c);//Adding c(new clothing object) to the product;Using methode
                        System.out.println("\nThe product was successfully added to the system\n ");
                        break;

                    case 0:
                        quit = true;
                        System.out.println("you are back to the main menu!");
                        break;

                    default:
                        System.out.println("Incorrect option ; Please try again ");

                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }

    }
    public ArrayList<Product> getProductListArray() {

     return productsList;
    }

    public void validateID() {//id validating method
        System.out.println("Please enter the product ID : ");
        productId = sc.nextLine();
        for (int i = 0; i < productsList.size(); i++) {//walking through the array list
            Product product = productsList.get(i);

            while (product.getProductId().equals(productId)) {//check if the entered id is used or not
                System.out.println("This " + productId + "ID number already used for another product.\n Please re enter a valid ID number :");
                productId = sc.nextLine();
                System.out.println(" ");
            }

        }
    }

    public  void checkNumItem() {// checking integer number of items method

        while (true) {
            try {
                System.out.println("Please enter the number of product Item");
                numItem= sc.nextInt();
                break;
            }catch (InputMismatchException e) {
                System.err.println("Invalid input. ");
                sc.nextLine();

            }
        }

    }
    public  void checkProductPrice() {// checking valid double product price method

        while (true) {
            try {
                System.out.println("Please enter the product price :");
                productPrice = sc.nextDouble();
                break;
            }catch (InputMismatchException e) {
                System.err.println("Invalid input. ");
                sc.nextLine();

            }
        }

    }

    public  void checkProductSize() {//limited String size validating method

        while (true) {
            System.out.println("Please enter the product size (s, m, l, or xl):");
            size = sc.next();

            if (size.equals("s") || size.equals("m") || size.equals("l") || size.equals("xl")) {
                break; // Exit the loop if valid input is entered
            } else {
                System.out.println("Please re-enter a valid product size.");

            }
        }

    }

    public  void checkWarrantyMonths() {// checking integer  warranty method

        while (true) {
            try {
                System.out.println("Please enter the product warranty period(in months) :");
                 warrantyPeriod = sc.nextInt();
                break;
            }catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.nextLine();

            }
        }

    }


    public void addProduct(Product product) {//Product limitation checking methode and adding products to the productsList

        if (productsList.size() < 50) {
            productsList.add(product);
            if (productsList.size() == 49) {
                System.out.println("You can add only one more product item");
            }

        } else {
            System.out.println("Maximum limit of products reached.This above product item cannot be add");
        }
    }

    public void deleteProduct() {//Product deleting method
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter the product ID : ");
        productId = sc.next();
        for (int i = 0; i < productsList.size(); i++) {//walking through the array list
            Product product = productsList.get(i);

            if (product.getProductId().equals(productId)) {//if id equals removing the product from the list
                productsList.remove(i);

                System.out.println(product.getClass().getSimpleName() + " product with ID number " + productId + " has been deleted");

                System.out.println("Total number of products left: " + productsList.size());//printing the number of products
                System.out.println(" ");
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);//error message if product id is not found
        System.out.println(" ");
    }



    public void printProductList() {//Products printing and sorting method
        System.out.println("----------------------------------------------------");
        int n = productsList.size();

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Product product1 = productsList.get(j);
                Product product2 = productsList.get(j + 1);
                // Compare productIDs and swap if needed
                if (product1.getProductId().compareTo(product2.getProductId()) > 0) {
                    // Swap products
                    productsList.set(j, product2);
                    productsList.set(j + 1, product1);
                }
            }
        }


        for (Product product : productsList) { // Print sorted product list
            product.displayAllInfo();//abstract method
        }
    }
    public void fileSaveProduct() {//saving product objects to the file
        try (FileOutputStream fos = new FileOutputStream("Productt_List.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(productsList);
            System.out.println("Products saved successfully.");
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Products saving objects: ");
            e.printStackTrace();  // print the stack trace for debugging
        }
    }




  public void loadProduct() {//loading saved objects
      try (FileInputStream fis = new FileInputStream("Productt_List.txt");
           ObjectInputStream ois = new ObjectInputStream(fis)) {

          productsList = (ArrayList<Product>) ois.readObject();
          //for (Product product : productsList) {
             // System.out.println(product);
        //  }

      } catch (IOException | ClassNotFoundException e) {
          System.err.println("Error loading Products ");
          e.printStackTrace();  // print the stack trace for debugging
      }
  }
    public void OpenCustomerMenu() {//Opening the GUI
        ShoppingCart gui = new ShoppingCart(productsList, this);
    }

       public void AdminLogin(){//login to the system ;using office email
        System.out.println("Please enter your office email to access to the system :");
        String email = sc.next();
            while (!email.contains("Staff@gmail.com")) {//validation for the e-mail
        System.out.println("Invalid email. Please enter a valid Gmail address.");
        email = sc.next();
    }
           AdminMenu();
 }
    public boolean AdminMenu() {//Child menu, for the system operations

        boolean quit = false;
        System.out.println("\n 'Welcome to the Westminster Shopping Centre'");
        int option;
        loadProduct();

        while (!quit) {
            try {
                System.out.println("----------------------------------------------------");
                System.out.println("To Add a new product press 1");
                System.out.println("To print the list of the products press 2");
                System.out.println("To delete a product press 3");
                System.out.println("To save the products press 4");
                System.out.println("To exit press 0");
                System.out.println("----------------------------------------------------");
                System.out.println(" ");
                System.out.print("Choose an option : ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        this.addProducts();
                        break;

                    case 2:
                        this.printProductList();
                        break;

                    case 3:
                        deleteProduct();
                        break;

                    case 4:
                        fileSaveProduct();
                        break;


                    case 0:
                        quit = true;
                        System.out.println("Bye...!");
                        break;

                    default:
                        System.out.println("Incorrect option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        return quit;
    }


    public boolean MENU() {//parent menu ,for registered,unregistered customers and admins

        boolean quit = false;
        System.out.println("\n 'Welcome to the Westminster Shopping Centre'");
        int option;
        loadProduct();
        loadObjuser();
        while (!quit) {
            try {
                System.out.println("----------------------------------------------------");
                System.out.println("To register as a customer enter 1");
                System.out.println("To log in to the  system as a customer enter 2");
                System.out.println("To operate the system as an admin  enter 3");
                System.out.println("To exit press 0");
                System.out.println("----------------------------------------------------");
                System.out.println(" ");
                System.out.print("Choose an option : ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        userRegister();
                        break;

                    case 2:
                        userLogin();
                        break;
                    case 3:
                        AdminLogin();
                        break;


                    case 0:
                        quit = true;
                        System.out.println("Bye...!");
                        break;

                    default:
                        System.out.println("Incorrect option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        return quit;
    }

}


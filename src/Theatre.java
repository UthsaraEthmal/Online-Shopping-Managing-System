import java.io.*;
import java.util.*;
import java.io.BufferedReader;
public class Theatre {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Ticket> Ticket_list = new ArrayList<Ticket>();//list declaration
    public static int[] row1 = new int[12];//array declaration and initialization for row 1
    public static int[] row2 = new int[16];//array declaration and initialization for row 2
    public static int[] row3 = new int[20];//array declaration and initialization for row 3
    static int seat = 0;
    static int row = 0;

    static int buy_ticket() {//method for book tickets
        try {// this try and catch block use for InputMismatchException e in this method.
            System.out.println("	** Book Your Tickets **");
            System.out.println("   -------------------------");

            row_selection();// a method for enter a row number with checking the correct input.
        while(true){//infinite loop until condition true
            try{//this try and catch block requesting an integer value

            if (row == 1) {
                if (row == 1) {
                    System.out.print("Enter the seat number(1-12) : ");
                    seat = sc.nextInt();
                    while (seat < 1 || seat > 12) {//validation for the limiting numbers of seats in first row
                        System.out.print("Wrong number of seat;Please re-enter : ");
                        seat = sc.nextInt();
                    }
                }
                if (row1[seat - 1] == 1) {//to check the seat is already  booked or not
                    while (row1[seat - 1] == 1) {
                        System.out.print("The  seat already booked;Try again.\n Enter another seat number : ");
                        seat = sc.nextInt();
                    }
                }
                {
                    row1[seat - 1] = 1;//if seat booked correctly the value '0' replace with '1' to indicate the seat sold out.
                }
            }

            if (row == 2) {
                if (row == 2) {
                    System.out.print("Enter the seat number(1-16) : ");
                    seat = sc.nextInt();
                    while (seat < 1 || seat > 16) {//validation for the limiting numbers of seats in second row
                        System.out.print("Wrong number of seat;Please re-enter : ");
                        seat = sc.nextInt();
                    }
                }
                if (row2[seat - 1] == 1) {//to check the seat is already  booked or not
                    while (row2[seat - 1] == 1) {
                        System.out.print("The seat already booked;Try again.\n Enter another seat number : ");
                        seat = sc.nextInt();
                    }
                }
                {
                    row2[seat - 1] = 1;//if seat booked correctly the value '0' replace with '1' to indicate the seat sold out.
                }
            }

            if (row == 3) {
                if (row == 3) {
                    System.out.print("Enter the seat number(1-20) : ");
                    seat = sc.nextInt();
                    while (seat < 1 || seat > 20) {
                        System.out.print("Wrong number of seat;Please re-enter : ");
                        seat = sc.nextInt();
                    }
                }
                if (row3[seat - 1] == 1) {
                    while (row3[seat - 1] == 1) {
                        System.out.println("The  seat already booked;try again.\n Enter another seat number : ");
                        seat = sc.nextInt();
                    }
                }
                {
                    row3[seat - 1] = 1;//if seat booked correctly the value '0' replace with '1' to indicate the seat sold out.
                }
            }
            break;
             } catch (InputMismatchException e) {
                System.out.print("Invalid input.Please re-enter a valid seat : ");
                sc.nextLine();
             }
    }
            System.out.println("Enter your name : ");
            String name = sc.next();
            System.out.println("Enter your surname : ");
            String surname = sc.next();
            System.out.println("Enter your email ");
            String email = sc.next();
            while (!email.contains("@gmail.com")) {//validation for the e-mail
                System.out.println("Invalid email. Please enter a valid Gmail address.");
                email = sc.next();
            }

            double price;
            while (true) {//validation for the price
                System.out.println("Enter a price: ");
                try {//this try and catch block use for InputMismatchException e .
                    price = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid price.");
                    sc.nextLine();
                }
            }

            System.out.println("Hey! " + name + " " + surname + " , the seat you booked is row " + row + " seat number " + seat);//a message
            System.out.println("..................................................... ");
            Person customer = new Person(name, surname, email);//getting inputs from user (using Person.java class)
            Ticket T1 = new Ticket(row, seat, price, customer);//getting inputs from user (using Ticket.java class)
            Ticket_list.add(T1);//adding data to the list
            T1.print();//printing the data of the list
            System.out.println("..................................................... ");
            System.out.println("thank you ! ");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.next();
        }
        return row;
        }
    static int print_seating_area() {//method for print the seating area
        System.out.print("     ***********\n");
        System.out.println("     *  STAGE  *");
        System.out.print("     ***********");

        System.out.print("\n    ");
        for (int i = 0; i < row1.length; i++) {//limiting the length of array for row 1
            if (i == 6) {//for the middle gap
                System.out.print(" ");
            }
            if (row1[i] == 1) {//if the seat booked it shows as 'X' else 'O'.
                System.out.print("X");
            } else {
                System.out.print("O");
            }

        }
        System.out.println(" ");

        System.out.print("  ");
        for (int i = 0; i < row2.length; i++) {//limiting the length of array for row 2.
            if (i == 8) {//for the middle gap
                System.out.print(" ");
            }
            if (row2[i] == 1) {//if the seat booked it shows as 'X' else 'O'.
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println(" ");

        for (int i = 0; i < row3.length; i++) {//limiting the length of array for row 1
            if (i == 10) {//for the middle gap
                System.out.print(" ");
            }
            if (row3[i] == 1) {//if the seat booked it shows as 'X' else 'O'.
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println(" ");
        return 0;
    }

    private static void cancel_ticket() {

        System.out.println("	** Cancel Tickets **");

        row_selection();// a method for enter a row number with checking the correct input.
        while(true){//infinite loop until condition true
            try{//this try and catch block requesting an integer value
        if (row == 1) {
            System.out.print("Enter the seat number(1-12) : ");
            seat = sc.nextInt();
            if (seat < 1 || seat > 12) {
                System.out.print("wrong number of seat;Please re-enter : ");
                seat = sc.nextInt();
            }
            if (row1[seat - 1] == 1) {//if the  element of the array assign as the '1' the element replace with '0'.
                System.out.print("The seat you booked,Is now canceled");
                deleting_from_arraylist();
                row1[seat - 1] = 0;
                System.out.println();
            } else {//if the  element of the array assign as the '0' telling user it is still free.
                System.out.println("The seat you entered is row " + row + " seat number " + seat + " still free and here  menu for booking.");

            }
        }
        if (row == 2) {
            System.out.print("Enter the seat number(1-16) : ");
            seat = sc.nextInt();
            if (seat < 1 || seat > 16) {
                System.out.print("Wrong number of seat;Please re-enter : ");
                seat = sc.nextInt();
            }
            if (row2[seat - 1] == 1) {//if the  element of the array assign as the '1' the element replace with '0'.
                System.out.print("The seat you booked,Is now canceled");
                deleting_from_arraylist();
                row2[seat - 1] = 0;
                System.out.println();
            } else {//if the  element of the array assign as the '0' telling user the seat is still free.
                System.out.println("The seat you entered is row " + row + " seat number " + seat + "still free and go back to the menu for booking");
            }
        }
        if (row == 3) {
            System.out.print("Enter the seat number(1-20) : ");
            seat = sc.nextInt();
            if (seat < 1 || seat > 20) {
                System.out.print("Wrong number of seat;Please re-enter : ");
                seat = sc.nextInt();
            }
            if (row3[seat - 1] == 1) {//if the  element of the array assign as the '1' the element replace with '0'.
                System.out.print("The seat you booked,Is now canceled");
                deleting_from_arraylist();
                row3[seat - 1] = 0;
                System.out.println();
            } else {//if the  element of the array assign as the '0' telling user the seat is still free.
                System.out.println("The seat you entered is row " + row + " seat number " + seat + "still free and go back to the menu for booking");
            }
        }
        System.out.println("--------------------------------------- ");
    break;
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. ");
            sc.nextLine();
        }
    }
    }


    private static int show_available() {

        System.out.print("Seats available in row 1 : ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {//'i' is the number of the index ,if the element of the 'i' assign as '0' it shows as free seat
                System.out.print(i + 1);
                System.out.print(" ,");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 2 : ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {//'i' is the number of the index ,if the element of the 'i' assign as '0' it shows as free seat
                System.out.print(i + 1);
                System.out.print(" ,");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 3 : ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {//'i' is the number of the index ,if the element of the 'i' assign as '0' it shows as free seat
                System.out.print(i + 1);
                System.out.print(" ,");
            }
        }
        System.out.println(" ");
        return 0;
    }

    static void save() {
        try {
            FileWriter data_save = new FileWriter("Seating_area.txt");//name of the file
            data_save.write("\n                 ***********");//commands to write on the file
            data_save.write("\n                 *  STAGE  *");
            data_save.write("\n                 ***********");

            data_save.write("\nFirst row  :    ");
            for (int i = 0; i < row1.length; i++) {
                if (i == 6) {
                    data_save.write(" ");
                }
                if (row1[i] == 1) {
                    data_save.write("X");
                } else {
                    data_save.write("O");
                }

            }

            data_save.write("\nSecond row :  ");
            for (int i = 0; i < row2.length; i++) {
                if (i == 8) {
                    data_save.write(" ");
                }
                if (row2[i] == 1) {
                    data_save.write("X");
                } else {
                    data_save.write("O");
                }
            }
            data_save.write("\nThird row  :");

            for (int i = 0; i < row3.length; i++) {
                if (i == 10) {
                    data_save.write(" ");
                }
                if (row3[i] == 1) {
                    data_save.write("X");
                } else {
                    data_save.write("O");
                }
            }
            data_save.write("\n  ");
            data_save.write("\n----(Free seats shows as 'O' else 'X'.)---- ");
            data_save.close();//to print the data on the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Seating_area.txt"));
            String line;
            while ((line = reader.readLine()) != null) {//to read line by line in until the end the file named 'Seating_area.txt'.
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show_tickets_info() {
        double total_price = 0;//assign total as double.

        for (Ticket ticket : Ticket_list) {//getting dta from the list(using Person.java and Ticket.java classes )
            System.out.println(" ");
            System.out.println("Name        : " + ticket.person.getName());
            System.out.println("Surname     : " + ticket.person.getSurname());
            System.out.println("E-mail      : " + ticket.person.getEmail());
            System.out.println("Row         : " + ticket.getRow());
            System.out.println("Seat        : " + ticket.getSeat());
            System.out.println("Ticket Price: £" + ticket.getPrice());
            System.out.println(" ");
            total_price += ticket.getPrice();// to add the price to the total
        }

        System.out.println("Total Price: £" + total_price);

    }
    public static void deleting_from_arraylist() {// to deleting ticket if the user want from the list
        for (int i = 0; i < Ticket_list.size(); i++) {
            if (Ticket_list.get(i).row == row & Ticket_list.get(i).seat == seat) {
                Ticket_list.remove(i);
            }
        }
    }
    public static void row_selection() {//to select the correct row number
        while (true) {//infinite loop until condition become true
            System.out.print("Enter a row number(1-3) : ");
           try{ row = sc.nextInt();//this try and catch block requesting an integer value
            if (row < 1 || row > 3) {
                do {
                    System.out.println("Wrong number of rows;Please re-enter : ");
                    row = sc.nextInt();
                } while (row < 1 || row > 3);
            }
            break;
        } catch (InputMismatchException e) {
        System.out.print("Invalid input. ");
        sc.nextLine();
    }
        }
    }


    public static void main(String[] args) {

        boolean quit = false;
        System.out.println(" 'Welcome to the New Theatre'");

        int option;

        while (!quit) {
            try {
                System.out.println("----------------------------------------------------");
                System.out.println("Please select an option : ");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area ");
                System.out.println("3) Cancel ticket");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file ");
                System.out.println("6) Load from file ");
                System.out.println("7) Print ticket information and total price ");
                System.out.println("8) Sort tickets by price");
                System.out.println("	0) Quit");
                System.out.println("----------------------------------------------------");

                System.out.print("Choose an option : ");
                option = sc.nextInt();

                switch (option) {

                    case 1:
                        buy_ticket();
                        break;

                    case 2:
                        print_seating_area();
                        break;

                    case 3:
                        cancel_ticket();
                        break;

                    case 4:
                        show_available();
                        break;

                    case 5:
                        save();
                        break;

                    case 6:
                        load();
                        break;

                    case 7:
                        show_tickets_info();
                        break;

                    case 8:
                     //sort_ticket();
                        System.out.println("The sort part is not completed");
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

    }

}



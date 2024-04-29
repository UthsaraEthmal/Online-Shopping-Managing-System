import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class  ShoppingCart {
    static ArrayList<Product> productsList;
    public WestminsterShoppingManager shoppingManager;

    String[] Col = {"Product ID", "Name", "Category", "Price($)","info"};
    DefaultTableModel tableModel1 =new DefaultTableModel(Col,0);
    JFrame frame1 = new JFrame("Westminster Shopping Center");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton button1 = new JButton("Shopping Cart");
    JButton button2 = new JButton("Add to Cart");
    JLabel label1 = new JLabel("Select Product Category ");
    JTable table1=new JTable(tableModel1);
    JScrollPane scrollPane1=new JScrollPane(table1);
    JLabel label2=new JLabel("Selected Product - Details");
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();

    JLabel label6 = new JLabel();
    JLabel label7=new JLabel();
    JLabel label8=new JLabel();
    JLabel label9=new JLabel();
    JLabel label10 = new JLabel();
    JLabel label11 = new JLabel();
    JLabel label12 = new JLabel();
    JLabel label13 = new JLabel();
    JLabel label14 = new JLabel();
    JLabel label15 = new JLabel();
    JLabel label16 = new JLabel();
    JComboBox<String> comboBox1;


    //for new window2
    JFrame frame2 = new JFrame("Shopping Cart");
    JPanel panel5=new JPanel();
    JPanel panel6=new JPanel();
    JTable table2 = new JTable();
    JScrollPane scrollPane = new JScrollPane(table2);

    JLabel label17 =new JLabel("Total ($)");
    JLabel label18 =new JLabel();
    JLabel label19 =new JLabel("First Purchase Discount(10%)");
    JLabel label20 =new JLabel("Three Items in same Category Discount(20%)");
    JLabel label21 =new JLabel("Final Total");
    JPanel panel7= new JPanel();
    //   Object []row =new Object[3];
    DefaultTableModel tablemodel2 = new DefaultTableModel();


    public ShoppingCart(ArrayList<Product> productsList, WestminsterShoppingManager shoppingManager) {
        this.productsList = productsList;
        this.shoppingManager = shoppingManager;

        table1.setGridColor(Color.black);
        tableModel1.setRowCount(0);
        // productsList.sort((p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        addToTable();//calling method to fill the table data

        String[] categories = {"All", "Electronics", "Clothings"};//adding categories to combobox
        comboBox1 = new JComboBox<>(categories);//creating


        panel1.setBackground(Color.orange);
        panel1.setBounds(0, 0, 800, 100);
        panel1.setLayout(null);
        panel1.add(label1);
        label1.setBounds(175, 20, 220, 20);

        panel1.add(comboBox1);
        comboBox1.setBounds(335, 20, 150, 20);

        panel1.add(button1);
        button1.setBounds(580, 5, 120, 20);

        panel2.setBackground(Color.GRAY);

        panel2.setBounds(15, 110, 760, 150);

        panel2.add(scrollPane1);
        //panel2.setLayout(null);
        //panel2.add(scrollPane1,table2);
        //table2.add(tableModel1);
        panel2.setLayout(new BorderLayout());
        panel2.add(scrollPane1);


        TableColumnModel columnModel=table1.getColumnModel();//changing column width
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(120);

        table1.setSize(750,125);

        panel3.setBounds(12, 270, 760, 300);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.setLayout(null);

        panel3.add(button2);
        button2.setBounds(340, 260, 120, 20);

        panel3.add(label2);
        label2.setBounds(175,10,180,20);

        panel3.add(label3);
        panel3.add(label4);
        panel3.add(label5);
        panel3.add(label6);
        panel3.add(label7);
        panel3.add(label8);
        panel3.add(label9);
        panel3.add(label10);
        panel3.add(label11);
        panel3.add(label12);
        panel3.add(label13);
        panel3.add(label14);
        panel3.add(label15);
        panel3.add(label16);

        label3.setBounds(240,50,190,20);//For Product Id
        label10.setBounds(170,50,70,20);

        label4.setBounds(240,80,190,20);//For Product Name
        label11.setBounds(170,80,70,20);

        label5.setBounds(240,110,190,20);//For Product Category
        label12.setBounds(170,110,70,20);

        label6.setBounds(240,140,190,20);//For Product Price
        label13.setBounds(170,140,70,20);

        label7.setBounds(240,170,190,20);//For size or warranty
        label14.setBounds(170,170,70,20);

        label8.setBounds(240,200,190,20);//For color or brand
        label15.setBounds(170,200,70,20);

        label9.setBounds(170,230,100,20);//For Availability
        label16.setBounds(280,230,190,20);

        frame1.setSize(800, 620);
        frame1.setVisible(true);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(panel3);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            comboBoxFilter();

            }
        });

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                creatingTable();
                frame2.setVisible(true);//frame2 appearance

            }
        });

        button2.addActionListener(new ActionListener() {
            private boolean frameCreated = false;//checks window is created or not
            @Override
            public void actionPerformed(ActionEvent ed) {
                addToCart ();//calling method to pass selected  items to the cart
            }
        });


        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
             displayValues();
            }
        });


    }

    public void comboBoxFilter(){//filtering Categorises


        String selectedCategory = (String) comboBox1.getSelectedItem(); // selected category item

        tableModel1.setRowCount(0);


        if ("Electronics".equals(selectedCategory)) {//first condition
            for (int i = 0; i < productsList.size(); i++) {//walking through the array list
                Product product = productsList.get(i);
                if (product instanceof Electronics) {
                    // Add row to the table
                    Object[] row = ShoppingCenRow(product);
                    tableModel1.addRow(row);
                }
            }
            // System.out.println("Selected category: Electronics");
        } else if("Clothings".equals(selectedCategory)) {//second condition
            try{
                for (int i = 0; i < productsList.size(); i++) {//walking through the array list
                    Product product = productsList.get(i);
                    if (product instanceof Clothing) {
                        // Add row to the table
                        Object[] row = ShoppingCenRow(product);
                        tableModel1.addRow(row);
                    }
                }
            }catch (ClassCastException error){
                System.out.println("Selected category: Clothings");
            }
            //  System.out.println("Selected category: Clothings");
        } else {//third condition

            for (int i = 0; i < productsList.size(); i++) {//walking through the array list
                Product product = productsList.get(i);
                Object[] row = ShoppingCenRow(product);
                tableModel1.addRow(row);
            }
            //    System.out.println("Selected category: All");
        }

    }



public void displayValues(){

    try{
        int selectedRow = table1.getSelectedRow();
        if (selectedRow >= 0) {
            Object[] rowData = new Object[tableModel1.getColumnCount()];
            for (int i = 0; i < tableModel1.getColumnCount(); i++) {
                rowData[i] = table1.getValueAt(selectedRow, i);
            }

            label3.setText("" + rowData[0]);
            label4.setText("" + rowData[1]);
            label5.setText("" + rowData[2]);
            label6.setText("" + rowData[3]);

            label10.setText("ID   : ");
            label11.setText("Name   : ");
            label12.setText("category   : ");
            label13.setText("Price   : ");
            label9.setText("Items Available  : ");

            if (rowData[2].equals("Clothing")) {
                label7.setText("" + ((String) rowData[4]).split(",")[0].trim());
                label8.setText(" " + ((String) rowData[4]).split(",")[1].trim());
                label14.setText("Size   : ");
                label15.setText("Colour   : ");

                Clothing selectedC = (Clothing) productsList.get(selectedRow);//getting NumItems within the array
                label16.setText(" " + selectedC.getNumItem());

            } if (rowData[2].equals("Electronic")){
                label7.setText(" " + ((String) rowData[4]).split(",")[0].trim());
                label8.setText(" " + ((String) rowData[4]).split(",")[1].trim());
                label14.setText("Brand   : ");
                label15.setText("Warranty   : ");


                Electronics selectedE = (Electronics) productsList.get(selectedRow);
                label16.setText(" " + selectedE.getNumItem());
            }
        }
    }catch (ClassCastException error){
        JOptionPane.showMessageDialog(null,"Please select a Category","Message",JOptionPane.INFORMATION_MESSAGE);
    }

}
    public void creatingTable() {


        frame2.setSize(600, 500);
        frame2.setLayout(null);

        frame2.setLayout(new GridLayout(2,1));
        frame2.add(panel5);
        frame2.add(panel6);

        String[] Col2 = {"Product", "Quantity", "Price($)"};

        panel5.add(scrollPane);
        panel5.setLayout(null);
        panel5.setBackground(Color.orange);
        panel5.add(scrollPane,table2);

        tablemodel2.setColumnIdentifiers(Col2);
        table2.setModel(tablemodel2);
        table2.setRowHeight(40);
        table2.setSize(250,200);
        //JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setBounds(40, 10, 500, 200);

        panel6.setBounds(0,210,600,290);
        panel6.setBackground(Color.GRAY);
        panel6.setLayout(null);


        panel7.setBounds(90,40,400,140) ;
        panel7.setLayout(null);
        panel6.add(panel7);
        panel7.add(label17);
        panel7.add(label18);
        panel7.add(label19);
        panel7.add(label20);
        panel7.add(label21);
        label17.setBounds(30,20,280,20);
        label18.setBounds(310,20,120,20);
        label19.setBounds(30,40,280,20);
        label20.setBounds(30,60,280,20);
        label21.setBounds(30,90,280,20);


        frame2.setResizable(false);
    }



    private Object[] ShoppingCenRow(Product product) {
        if (product instanceof Electronics) {
            Electronics e = (Electronics) product;

            return new Object[]{e.getProductId(), e.getProductName(), "Electronic", e.getProductPrice(),
                    e.getBrand() + " , " + e.getWarrantyPeriod() + " months", e.getNumItem()};
        } else {
            Clothing c = (Clothing) product;

            return new Object[]{c.getProductId(), c.getProductName(), "Clothing", c.getProductPrice(),
                    c.getSize() + " , " + c.getColour(), c.getNumItem()};
        }
    }


    public void alphabetcalProductList() {//Products printing and sorting method

        int n = productsList.size();

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Product product1 = productsList.get(j);
                Product product2 = productsList.get(j + 1);

                if (product1.getProductName().compareTo(product2.getProductName()) > 0) {// checking productIDs for swap

                    productsList.set(j, product2);//swap
                    productsList.set(j + 1, product1);
                }
            }
        }}
    public void addToCart (){
        try {

            creatingTable();//Creating frame2 and table method


            String productId = label3.getText();
            String productName = "\n" + label4.getText() + "\n";
            String productDetails = label7.getText() + ", " + label8.getText();
            double productPrice = Double.parseDouble(label6.getText());

            String newRowData = productId + ",\n" + productName + ",\n" + productDetails;//new row

            int quantity = 1;

            boolean productIs = false;// Checking , the product already  in the table (cart) or not


            for (int i = 0; i < tablemodel2.getRowCount(); i++) {//walking through the table
                String productCheck = tablemodel2.getValueAt(i, 0).toString();


                if (productCheck.equals(newRowData)) {//If product found in the cart
                    int numItem = Integer.parseInt(tablemodel2.getValueAt(i, 1).toString());
                    double productTotal = (numItem + 1) * productPrice; // Calculate total cost
                    tablemodel2.setValueAt(numItem + 1, i, 1); // Increasing quantity
                    tablemodel2.setValueAt(productTotal, i, 2); // Update total cost in the third column
                    productIs = true;


                    int numAvailable = Integer.parseInt(label16.getText().trim());//getting label6 value
                    if (numAvailable > 0) {

                        label16.setText(" " + (numAvailable - 1));
                    }if(numAvailable == 1){
                        JOptionPane.showMessageDialog(null,"Out of stock.","Message",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                }
            }
            if (!productIs) {//new product to  the table cart
                double productTotal = quantity * productPrice; // Calculate total cost for the new product
                Object[] newRow = {newRowData, quantity, productPrice, productTotal};
                tablemodel2.addRow(newRow);
                //  JOptionPane.showMessageDialog(null,"The New product has been added to the cart.","Message",JOptionPane.INFORMATION_MESSAGE);

                int numAvailable = Integer.parseInt(label16.getText().trim());//getting label6 value
                if (numAvailable > 0) {
                    label16.setText(" " + (numAvailable - 1));
                }if(numAvailable == 1){

                    JOptionPane.showMessageDialog(null,"Out of stock.","Message",JOptionPane.ERROR_MESSAGE);
                }
            }
            FinalTotal();
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please select a Product","Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    public void FinalTotal() {
        double finalTotal = 0;

        for (int i = 0; i < tablemodel2.getRowCount(); i++) {
            double productTotal = Double.parseDouble(tablemodel2.getValueAt(i, 2).toString());
            finalTotal += productTotal;
        }

        label18.setText(":  " + finalTotal);


    }




    public void addToTable(){

            alphabetcalProductList();
        for (int i = 0; i < productsList.size(); i++) {//walking through the array list
            Product product = productsList.get(i);
            if(product instanceof Electronics){
                Electronics e =(Electronics) product;
                Object[] row={e.getProductId(), e.getProductName(),"Electronic",e.getProductPrice(),e.getBrand()+" , "+e.getWarrantyPeriod()+"months",e.getNumItem()} ;
                tableModel1.addRow(row);
            }else{
                Clothing c =(Clothing) product;
                Object[] row={c.getProductId(), c.getProductName(),"Clothing",c.getProductPrice(),c.getSize()+" , "+ c.getColour(),c.getNumItem()};
                tableModel1.addRow(row);
            }

        }




}
}
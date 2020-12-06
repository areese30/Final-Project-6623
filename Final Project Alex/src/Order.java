/*Name:     Alexander Reese
Assignment: 4
Instructor: Yan Huang
Term: Fall  2020
IDE:        VSC*/

import java.io.*;
import java.util.Date;

public class Order{

    private int orderid;
    private String username;
    private Date dateCreated;
    private String[][] cart;

    public Order(int neworderid, String newusername) {
            orderid = neworderid;
            dateCreated = new Date();
            username = newusername;
    }

    public int getOrderID(){ // get order id method
        return orderid;
    }

   public Date getDateCreated(){ // get date created method
        return dateCreated;
    }

    public String getUsername(){ // get username method
        return username;
    }

    void fillCart(int quan, String [][] list){
        cart = new String[quan][2];

        for (int i = 0; i < cart.length; i++){
            for (int j = 0; j < cart[i].length;j++){
                cart[i][j] = list[i][j];
            }
        }
    }

    void commit() throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("WantBuy.csv"));
        System.setOut(out);
        for (int i = 0; i < cart.length; i++) {
            for (int j = 0; j < cart[i].length; j++) {
                System.out.print(cart[i][j] + " ");
            }
            System.out.println();
        }
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
    }
    void mycommit() throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("NewOwn.csv"));
        System.setOut(out);
        for (int i = 0; i < cart.length; i++) {
            for (int j = 0; j < cart[i].length; j++) {
                System.out.print(cart[i][j] + " ");
            }
            System.out.println();
        }
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
    }

    void hiscommit() throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Own.csv"));
        System.setOut(out);
        for (int i = 0; i < cart.length; i++) {
            for (int j = 0; j < cart[i].length; j++) {
                System.out.print(cart[i][j] + " ");
            }
            System.out.println();
        }
        PrintStream console = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console);
    }
    public class shippingInfo{

    }


}
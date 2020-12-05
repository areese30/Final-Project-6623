import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Random;
import java.lang.String;

public class TestUser {

    public static void main(String[] args) throws FileNotFoundException { // main program

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Scanner input = new Scanner(System.in); // new scanner objects
        Scanner type = new Scanner(System.in);
        Scanner again = new Scanner(System.in);
        Scanner let = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner position = new Scanner(System.in);
        String another;

        String firstname;
        String lastname;
        int cardInfo;
        String address;
        String username;
        String choice;

        System.out.println("What is your First name: "); // Prompt for Person Object
        firstname = type.nextLine();

        System.out.println("What is your Last name: "); // Prompt for Person Object
        lastname = type.nextLine();

        System.out.println("What is your address: ");
        address = type.nextLine();

        System.out.println("What is your cardInfo: ");
        cardInfo = type.nextInt();

        User newUser = new User(firstname, lastname, cardInfo, address);

        System.out.println("User Object:"); // Output of Person Object
        System.out.println(newUser);

        System.out.println();

        System.out.println("Are you a recent customer?");
        another = input.nextLine();
        String[][] myhardware = CsvoutParser.parser();
        if (another.equalsIgnoreCase("Yes")) {
            System.out.println("Welcome back, this is what you have previously bought ");
            for (int i = 0; i < myhardware.length; i++) {
                for (int j = 0; j < myhardware[i].length; j++) {
                    System.out.print(myhardware[i][j] + " ");
                }
                System.out.println();
            }
        }

        String decision;
        System.out.println("Would you like to place an order?");
        decision = input.nextLine();
        String[][] hardware = CsvParser.parser();

        if (decision.equalsIgnoreCase("Yes")) {

            Random id = new Random();
            int orderid;
            orderid = id.nextInt(100);
            System.out.println("Enter your username:");
            username = type.nextLine();
            Order newOrder = new Order(orderid, username);
            System.out.println(newOrder);
            System.out.println("order id created: " + orderid);

            System.out.print("How many items would you like to buy? ");
            int quanity = scan.nextInt();
            String[][] list = new String[quanity][2];
            System.out.print("What item would you like to buy? ");
            for (int i = 0; i < hardware.length; i++) {
                for (int j = 0; j < hardware[i].length; j++) {
                    System.out.print(hardware[i][j] + " ");
                }
                System.out.println();
            }


            String itemid = "";

            for (int i = 0; i < quanity; i++) {
                String item = let.nextLine();
                for (int j = 0; j < hardware.length; j++) {

                    if (item.equals(hardware[j][0])) {
                        itemid = hardware[j][1];
                        list[i][0] = item;
                        list[i][1] = itemid;
                        break;
                    }
                }
            }

            newOrder.fillCart(quanity, list);
            newOrder.commit();
            

            String[][] mylist = new String[quanity][2];
            myhardware = CsvoutParser.parser();


            String yourid = "";

            for (int i = 0; i < quanity; i++) {
                String item = let.nextLine();
                for (int j = 0; j < myhardware.length; j++) {

                    if (item.equals(myhardware[j][0])) {
                        yourid = myhardware[j][1];
                        mylist[i][0] = item;
                        mylist[i][1] = yourid;
                        break;
                    }
                    newOrder.fillCart(quanity, list);
                    newOrder.mycommit();


                }
            }
            if (Arrays.deepEquals(list,myhardware)){
                System.out.println("You have some items in your shopping cart that are similar. Would you like to proceed?");
                choice = again.nextLine();
                if (choice.equalsIgnoreCase("yes")){
                    System.out.print("Order Complete");
                }else{
                    System.out.print("Order Complete");
                }
            }
            System.out.println("Thank you for shopping.");
        }
    }
}
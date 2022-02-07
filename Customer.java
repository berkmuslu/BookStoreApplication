import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Customer {   // Customer database register and login.
    Scanner scan = new Scanner(System.in);
    private String username;
    private String password;

    Customer() {

    }

    public Customer(String uname, String pswd) {
        username = uname;
        password = pswd;
    }

    public static void newOrder(int id) { //New order menu
        Scanner scan = new Scanner(System.in);
        Display myCustomer = new Display();
        int input;

        Book.displayBooks();

        System.out.println("------------------");
        System.out.println("New Order");
        System.out.println("------------------");
        System.out.println("'-1' to Go Back");
        System.out.print("Book ID: ");

        input = scan.nextInt();// input from user for buying options

        if (input == -1) {

            myCustomer.customerMenu(id);

        } else if (input > Book.bookList.size()) { //Checks if input is valid

            System.out.println("There is no book with that ID");
            newOrder(id);

        } else {
            input--; //Input is decreased by 1 because ArrayLists starts from index 0
            int quantity;
            int stock = Book.bookList.get(input).bookStock;
            System.out.println("The base price for " + Book.bookList.get(input).bookName + " is " + Book.bookList.get(input).bookPrice + " TL");
            System.out.println("Stock: " + stock);


            System.out.print("Enter Quantity: ");
            quantity = scan.nextInt();

            while (quantity > stock) { //Checks if quantity is more than stock or not
                System.out.println("Quantity can not be more than stock!");
                System.out.print("Enter Quantity: ");
                quantity = scan.nextInt();

                if (quantity == -1) {
                    myCustomer.customerMenu(id);
                    break;
                }

            }

            double totalPrice = quantity * Book.bookList.get(input).bookPrice;
            System.out.println("----------------------");
            System.out.println("Total Price: " + totalPrice + " TL");
            System.out.println("----------------------");
            System.out.println("1.Confirm");
            System.out.println("2.Go Back");
            System.out.println("----------------------");
            System.out.print("Input: ");
            int confirm = scan.nextInt();


            if (confirm == 1) {
                int lines = 0;
                Book.bookList.get(input).bookStock = stock - quantity;
                Book.exportBooks(); //it exports updated ArrayList to TextFile

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("./db/bookPurchased.txt"));
                    while (reader.readLine() != null) lines++; //calculates lines of the ./db/bookPurchased.txt file
                    reader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(lines);

                try {

                    FileWriter fw = new FileWriter("./db/bookPurchased.txt", true); //the true will append the new data
                    if (lines != 0) { //checks if it's the first element
                        fw.write("\n" + id + "\n" + input + "\n" + quantity + "\n" + totalPrice); //appends the string to the file
                    } else {
                        fw.write(id + "\n" + input + "\n" + quantity + "\n" + totalPrice); //appends the string to the file
                    }
                    fw.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Purchase Successfully Done!");

                myCustomer.customerMenu(id);
            } else {
                myCustomer.customerMenu(id);
            }

        }


    }
}

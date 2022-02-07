import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Admin {

    String username;
    String password;

    Admin(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public void seeProfit() { //Run profitability calculator method

        final int profit = 5; // add 5 TL to profit sale by sale

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./db/bookPurchased.txt")); // Read total sales
            while (reader.readLine() != null) lines++;
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        double income = 0;

        try {
            File myFile = new File("./db/bookPurchased.txt");
            Scanner scanner = new Scanner(myFile);


            while (scanner.hasNextLine()) {
                for (int i = 0; i < 3; i++) {
                    scanner.nextLine();
                }
                String stringProfit = scanner.nextLine();
                income += Double.parseDouble(stringProfit);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        int total = lines / 4; // read divide lines in Database


        // print
        System.out.println("Profit");
        System.out.println("----------------------");
        System.out.println("Total Sales: " + total);
        System.out.println("----------------------");
        System.out.println("Total Income: " + income + " TL");
        System.out.println("----------------------");
        System.out.println("Total Profit: " + total * profit + " TL");
        System.out.println("----------------------");

        Scanner wait = new Scanner(System.in);
        wait.nextLine();
        Display myAdmin = new Display();
        myAdmin.adminPanel();


    }

}

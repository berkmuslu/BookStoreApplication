import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Display { //Mainmenu screen class Register or Login screen.
    Scanner scan = new Scanner(System.in);
    int secenek = 0, i = 0;
    boolean usersImported = false;
    boolean booksImported = false;


    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<String> userList = new ArrayList<String>();
    ArrayList<String> passList = new ArrayList<String>();
    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<String> adminList = new ArrayList<String>();
    ArrayList<String> adminPassList = new ArrayList<String>();


    private void importUsers() {       // import users data from file


        try {
            File myFile = new File("./db/userList.txt"); // username file
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                userList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        try {
            File myFile = new File("./db/passList.txt"); //user password file
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                passList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        try {
            File myFile = new File("./db/adminPassList.txt"); // admin password file 
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminPassList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        try {
            File myFile = new File("./db/adminList.txt"); // admin username file 
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        for (int j = 0; j < userList.size(); j++) {

            customers.add(new Customer(userList.get(j), passList.get(j)));

        }

        usersImported = true;

    }


    private void importBooks() { // import books from booklist database

        try {
            File myFile = new File("./db/bookList.txt"); // book database file
            Scanner myReader = new Scanner(myFile);

            String bookName;
            String bookAuthor;
            String tempBookPrice;
            String tempBookStock;
            double bookPrice;
            int bookStock;


            while (myReader.hasNextLine()) { // read method for books name,author,price and stock from database.

                bookName = myReader.nextLine();
                bookAuthor = myReader.nextLine();
                tempBookPrice = myReader.nextLine();
                tempBookStock = myReader.nextLine();


                bookPrice = Double.parseDouble(tempBookPrice);
                bookStock = Integer.parseInt(tempBookStock);

                bookList.add(new Book(bookName, bookAuthor, bookPrice, bookStock));


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        Book.importBooks(bookList);

        booksImported = true;

    }

    public void menu() { //Mainmenu

        if (!usersImported) {
            importUsers();
        }

        if (!booksImported) {
            importBooks();
        }


        i = 0;
        do {// main menu inputs.
            System.out.println("------------------");
            System.out.println("Main Menu");
            System.out.println("------------------");
            System.out.println("1.Customer Login");
            System.out.println("2.Admin Login");
            System.out.println("2.Exit");
            System.out.println("------------------");
            System.out.print("Enter: ");
            secenek = scan.nextInt(); // input from user for main menu selections.
            System.out.println("");
            switch (secenek) { //main menu options for user.
                case 1:
                    customerMenuLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("\nWrong Entry");
                    break;
            }

        } while (secenek != 3);
    }

    public void adminLogin() {// admin  Login menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Admin Login");
        System.out.println("------------------");
        System.out.println("Username: ");
        String uname = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();

        int id = -1;
        if (adminList.size() > 0) {//control username

            for (int i = 0; i < adminList.size(); i++) {

                if (uname.equals(adminList.get(i))) {// control in userlist, is there a valid username.

                    id = i;
                    break;

                }

            }

        }

        if (id != -1) {

            if (uname.equals((adminList.get(id))) && password.equals(adminPassList.get(id))) { // control id&password.
                System.out.println("------------------");
                System.out.println("Hello " + uname + "!");
                System.out.println("------------------");
                adminPanel(); // shows admin menu
            } else {
                System.out.println("Password is not correct!");

                menu();// return login menu if username or password is incorrect.
            }

        } else {
            System.out.println("User not found!");
        }


        secenek = scan.nextInt(); // get input from user.
        System.out.println("");
        switch (secenek) {//menu options

            case 1:
                customerLogin();
                break;

            case 2:
                menu();

            default:
                customerMenuLogin();

        }

    }

    public void adminPanel() {
        Admin admin = new Admin("admin", "admin");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-See Profit");
        System.out.println("2-Search");
        System.out.println("3-Logout");
        System.out.println("------------------");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                admin.seeProfit();
                break;
            case 2:
                Book.searchBooks();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Wrong entry!");
                adminPanel();

        }


    }


    public void customerMenuLogin() { //Customer Register and login option menu.

        System.out.println("------------------");
        System.out.println("Customer Menu");
        System.out.println("------------------");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Exit");
        System.out.println("------------------");
        System.out.print("Enter: ");
        secenek = scan.nextInt(); // get input from user.
        System.out.println("");
        switch (secenek) {//menu options


            case 1:
                customerLogin();
                break;

            case 2:
                customerRegister();

                break;

            case 3:
                menu();

            default:
                customerMenuLogin();

        }


    }

    public void customerLogin() {  //Login menu Username&Password.

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String uname = scn.next();// input username

        System.out.println("Enter Password: ");
        String password = scn.next();// input password

        int id = -1;
        if (userList.size() > 0) {//control username

            for (int i = 0; i < userList.size(); i++) {

                if (uname.equals(userList.get(i))) {// control in userlist, is there a valid username.

                    id = i;
                    break;

                }

            }

        }

        if (id != -1) {

            if (uname.equals((userList.get(id))) && password.equals(passList.get(id))) { // control id&password.
                System.out.println("------------------");
                System.out.println("Hello " + uname + "!");
                customerMenu(id); // shows customer menu
            } else {
                System.out.println("Password is not correct!");

                customerMenuLogin();// return login menu if username or password is incorrect.
            }

        } else {
            System.out.println("User not found!");
        }


    }


    public void customerRegister() { //Register Menu.
        Scanner scn = new Scanner(System.in);
        boolean check = true;
        while (check) {

            System.out.println("Enter Username: ");
            String uname = scn.next(); // New username input from user.

            System.out.println("Password must contain at least 8 characters long and must contain uppercase and lowercase characters and numbers.");
            System.out.println("Enter Password: ");

            String password = scn.next();// New Password input from user.

            if (password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) { // Check password requirements (at least 8 characters long and must contain uppercase and lowercase characters and numbers).

                userList.add(uname); // add username to userlist
                passList.add(password); //add password to passlist

                try {
                    String filename = "./db/userList.txt";
                    FileWriter fw = new FileWriter(filename, true); //the true will append the new data
                    fw.write("\n" + uname);//appends the string to the file
                    fw.close();
                } catch (IOException ioe) {
                    System.err.println("IOException: " + ioe.getMessage());
                }

                try {
                    String filename = "./db/passList.txt";
                    FileWriter fw = new FileWriter(filename, true); //the true will append the new data
                    fw.write("\n" + password);//appends the string to the file
                    fw.close();
                } catch (IOException ioe) {
                    System.err.println("IOException: " + ioe.getMessage());
                }

                System.out.println("Register Successful");
                check = false;
            } else { // shows error message if inputs does not match with requirements.
                System.out.println("Password is not matched with parameters!");
            }
        }
        customerMenuLogin();
    }

    public void customerMenu(int id) { // Customer Menu

        int input;

        System.out.println("------------------");
        System.out.println("Customer Menu");
        System.out.println("------------------");
        System.out.println("1.Buy a Book");
        System.out.println("2.Main Menu");
        System.out.println("------------------");
        System.out.print("Enter: ");
        input = scan.nextInt(); // Get input from user for menu progress.
        System.out.println("");
        switch (input) { //Menu options
            case 1:
                Customer.newOrder(id);
                break;
            case 2:
                menu();
                break;

            default:
                System.out.println("\nWrong Entry");
                customerMenu(id);
                break;
        }
    }


}



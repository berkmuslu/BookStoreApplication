import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Book {

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    String bookName;
    String bookAuthor;
    double bookPrice;
    int bookStock;

    public Book(String name, String author, double price, int stock) {

        bookName = name;
        bookAuthor = author;
        bookPrice = price;
        bookStock = stock;

    }

    public Book() {

    }


    //Books are imported from an ArrayList in Display class to Books class's ArrayList 
    public static void importBooks(ArrayList<Book> bookText) {

        for (int i = 0; i < bookText.size(); i++) {

            bookList.add(bookText.get(i));

        }

    }

    public static void displayBooks() {         //displays Books on the terminal.
        System.out.println("Book List");
        System.out.println("------------------");
        int id = 1;
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("Book ID: " + id + " Book Name: " + bookList.get(i).bookName + " Book Author: " + bookList.get(i).bookAuthor + " Book Price: " + bookList.get(i).bookPrice + " TL Stock: " + bookList.get(i).bookStock);    // Shows books and prices.
            id++;
        }

    }

    public static void searchBooks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 1 for search by name");
        System.out.println("Press 2 for search by Author");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Enter the book's name.");
            String name = scan.nextLine();
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).bookName.equals(name)) {
                    System.out.println(" Book Name: " + bookList.get(i).bookName + " Book Author: " + bookList.get(i).bookAuthor + " Book Price: " + bookList.get(i).bookPrice + " TL Stock: " + bookList.get(i).bookStock);
                } else {
                    System.out.println("The dataset does not contain that book");
                    searchBooks();
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the book's Author.");
            String author = scan.nextLine();
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).bookAuthor.equals(author)) {
                    System.out.println(" Book Name: " + bookList.get(i).bookName + " Book Author: " + bookList.get(i).bookAuthor + " Book Price: " + bookList.get(i).bookPrice + " TL Stock: " + bookList.get(i).bookStock);
                } else {
                    System.out.println("The dataset does not contain a book from that author");
                    searchBooks();
                }

            }
        } else {
            System.out.println("Please enter a valid option");
            searchBooks();
        }
    }

    public static void exportBooks() { //Exports updated ArrayList to bookList.txt file

        try {
            File myFile = new File("./db/temp_books.txt");
            myFile.createNewFile(); //Creates a new file called temp_books.txt


        } catch (Exception e) {
            System.out.println("Couldn't create the file.");
            e.printStackTrace();
        }


        try {
            FileWriter myWriter = new FileWriter("./db/temp_books.txt"); //Reads inside the ArrayList and then writes it into temp_books.txt 
            for (int i = 0; i < bookList.size(); i++) {
                if (i == 0) { //if it's the first line then it does not put blank line
                    myWriter.write(

                            bookList.get(i).bookName + "\n" + bookList.get(i).bookAuthor + "\n" + bookList.get(i).bookPrice + "\n" + bookList.get(i).bookStock

                    );

                } else { //if it's not the first line then it puts blank line

                    myWriter.write(

                            "\n" + bookList.get(i).bookName + "\n" + bookList.get(i).bookAuthor + "\n" + bookList.get(i).bookPrice + "\n" + bookList.get(i).bookStock

                    );

                }
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try {
            File myFile = new File("./db/bookList.txt");
            myFile.delete();  //Deletes the bookList.txt
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File myFile = new File("./db/temp_books.txt");
            File myFile2 = new File("./db/bookList.txt");

            myFile.renameTo(myFile2); //Renames the temp_books.txt to bookList.txt

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

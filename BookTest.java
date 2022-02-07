import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void replaceUpdatedFiles(){

        int first_stock = 55;
        Book.bookList.add(new Book("Harry Potter","J.K. Rowling",25,55));

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/bookList.txt");
            myFileWriter.write("Harry Potter\nJ.K. Rowling\n25\n55");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }

        Book.bookList.get(0).bookStock = 50;

        try {
            File myFile = new File("./test_db/temp_books.txt");
            myFile.createNewFile();


        } catch (Exception e) {
            System.out.println("Couldn't create the file.");
            e.printStackTrace();
        }


        try {
            FileWriter myWriter = new FileWriter("./test_db/temp_books.txt");
            for (int i = 0; i < Book.bookList.size(); i++) {
                if(i == 0) {
                    myWriter.write(

                            Book.bookList.get(i).bookName + "\n" + Book.bookList.get(i).bookAuthor + "\n" + Book.bookList.get(i).bookPrice + "\n" + Book.bookList.get(i).bookStock

                    );

                }else {

                    myWriter.write(

                            "\n" + Book.bookList.get(i).bookName + "\n" + Book.bookList.get(i).bookAuthor + "\n" + Book.bookList.get(i).bookPrice + "\n" + Book.bookList.get(i).bookStock

                    );

                }
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try {
            File myFile = new File("./test_db/bookList.txt");
            myFile.delete();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            File myFile = new File("./test_db/temp_books.txt");
            File myFile2 = new File("./test_db/bookList.txt");

            myFile.renameTo(myFile2);

        }catch (Exception e){
            e.printStackTrace();
        }



        try {
    File myFile = new File("./test_db/bookList.txt");
    Scanner myReader = new Scanner(myFile);
    int last_stock = 0;

    while (myReader.hasNextLine()){

        myReader.nextLine();
        myReader.nextLine();
        myReader.nextLine();
        last_stock = Integer.parseInt(myReader.nextLine());
    }

    assertEquals(last_stock,Book.bookList.get(0).bookStock);
    assertNotEquals(first_stock,Book.bookList.get(0).bookStock);
        }catch (Exception e){
    e.printStackTrace();
        }




    }
}
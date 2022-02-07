import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void stockDecreaseTest() {

        boolean purchaseCompleted;
        Book.bookList.add(new Book("Harry Potter","JK Rowling",30,5));

        int input = 1;
        int quantity = 4;
        int first_stock = Book.bookList.get(input-1).bookStock;
        int last_stock = Book.bookList.get(input-1).bookStock - quantity;

        input--;
        int stock = Book.bookList.get(input).bookStock;
        System.out.println("Stock: " + stock);

        Book.bookList.get(input).bookStock = stock - quantity;

        assertNotEquals(first_stock,Book.bookList.get(input).bookStock);
        assertEquals(last_stock,Book.bookList.get(input).bookStock);


        System.out.println("Stock: " + Book.bookList.get(input).bookStock);

        if(last_stock < 0){purchaseCompleted=false;}else {purchaseCompleted=true;}
        System.out.println("Purchase Completed!");
        assertEquals(true,purchaseCompleted);


    }

    @Test
    void quantityMoreThanStocks() {

        boolean purchaseCompleted;

        Book.bookList.add(new Book("Harry Potter","JK Rowling",30,5));

        int input = 1;
        int quantity = 6;
        int first_stock = Book.bookList.get(input-1).bookStock;
        int last_stock = Book.bookList.get(input-1).bookStock - quantity;

        input--;
        int stock = Book.bookList.get(input).bookStock;
        System.out.println("\nStock: " + stock);

        Book.bookList.get(input).bookStock = stock - quantity;

        assertNotEquals(first_stock,Book.bookList.get(input).bookStock);
        assertEquals(last_stock,Book.bookList.get(input).bookStock);

        System.out.println("Stock: " + Book.bookList.get(input).bookStock);

        if(last_stock < 0){purchaseCompleted=false;}else {purchaseCompleted=true;}
        System.out.println("Purchase Failed!");
        assertNotEquals(true,purchaseCompleted);


    }

}

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {

    @Test
    void customerLogin_Positive() { //Positive Test

        ArrayList<String> userList = new ArrayList<String>();
        ArrayList<String> passList = new ArrayList<String>();

        String uname = "user";
        String password = "test";

        File myFile = new File("test_db/");
        if (!myFile.exists()) {
            myFile.mkdirs();
        }

        myFile = new File("./test_db/userList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./test_db/passList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/userList.txt");
            myFileWriter.write("user");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/passList.txt");
            myFileWriter.write("test");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }


        try {
            myFile = new File("./test_db/userList.txt");
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
            myFile = new File("./test_db/passList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                passList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }


        int id = -1;
        if (userList.size() > 0) {

            for (int i = 0; i < userList.size(); i++) {

                if (uname.equals(userList.get(i))) {

                    id = i;
                    break;

                }

            }

        }

        assertEquals(uname, userList.get(id));
        assertEquals(password, passList.get(id));


    }


    @Test
    void customerLogin_Negative() { //Negative Test

        ArrayList<String> userList = new ArrayList<String>();
        ArrayList<String> passList = new ArrayList<String>();

        String uname = "mytest";
        String password = "mytest";

        File myFile = new File("test_db/");
        if (!myFile.exists()) {
            myFile.mkdirs();
        }

        myFile = new File("./test_db/adminList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./test_db/passList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/userList.txt");
            myFileWriter.write("user");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/passList.txt");
            myFileWriter.write("test");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }


        try {
            myFile = new File("./test_db/userList.txt");
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
            myFile = new File("./test_db/passList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                passList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }


        int id = -1;
        if (userList.size() > 0) {

            for (int i = 0; i < userList.size(); i++) {

                if (uname.equals(userList.get(i))) {

                    id = i;
                    break;

                }

            }

        }

        assertEquals(-1, id);


    }

    @Test
    void adminLogin_Positive() { //Positive Test

        ArrayList<String> adminList = new ArrayList<String>();
        ArrayList<String> adminPassList = new ArrayList<String>();

        String a_name = "admin";
        String a_password = "admin";

        File myFile = new File("test_db/");
        if (!myFile.exists()){
            myFile.mkdirs();
        }

        myFile = new File("./test_db/adminList.txt");
        if(!myFile.exists()){
            try {
                myFile.createNewFile();
            }catch (Exception e){
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./test_db/adminPassList.txt");
        if(!myFile.exists()){
            try {
                myFile.createNewFile();
            }catch (Exception e){
                System.out.println("Couldn't create file!");
            }
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/adminList.txt");
            myFileWriter.write("admin");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/adminPassList.txt");
            myFileWriter.write("admin");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }


        try {
            myFile = new File("./test_db/adminList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        try {
            myFile = new File("./test_db/adminPassList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminPassList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }


        int id = -1;


        for (int i = 0; i < adminList.size(); i++) {

            if (a_name.equals(adminList.get(i))) {// control in userlist, is there a valid username.

                id = i;
                break;

            }

        }


        assertEquals(a_name,adminList.get(id));
        assertEquals(a_password,adminPassList.get(id));


    }



    @Test
    void adminLogin_Negative() { //Negative Test
        ArrayList<String> adminList = new ArrayList<String>();
        ArrayList<String> adminPassList = new ArrayList<String>();

        String a_name = "test";
        String a_password = "admin";

        File myFile = new File("test_db/");
        if (!myFile.exists()) {
            myFile.mkdirs();
        }

        myFile = new File("./test_db/adminList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./test_db/adminPassList.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/adminList.txt");
            myFileWriter.write("admin");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }

        try {
            FileWriter myFileWriter = new FileWriter("./test_db/adminPassList.txt");
            myFileWriter.write("admin");
            myFileWriter.close();

        } catch (IOException e) {
            System.out.println("Couldn't reach the file!");
        }


        try {
            myFile = new File("./test_db/adminList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }

        try {
            myFile = new File("./test_db/adminPassList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                adminPassList.add(myReader.next());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't reach the file!");
            e.printStackTrace();
        }


        int id = -1;


        for (int i = 0; i < adminList.size(); i++) {

            if (a_name.equals(adminList.get(i))) {// control in userlist, is there a valid username.

                id = i;
                break;

            }

        }


       assertEquals(-1,id);


    }

    @Test
    void passwordTest_Positive() {
        boolean passwordCheck = false;
        String password = "Berk1234";
        if (password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {

            passwordCheck = true;

        }

        assertEquals(true,passwordCheck);
    }


    @Test
    void passwordTest_Negative() {
        boolean passwordCheck = false;
        String password = "berk1234";
        if (password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {

            passwordCheck = true;

        }

        assertNotEquals(true,passwordCheck);
    }


}




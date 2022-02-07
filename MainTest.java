import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void createRequiredFiles() {

        File myFile = new File("test_db/");
        if (!myFile.exists()){
            myFile.mkdirs();
        }

        File myFile1 = new File("./test_db/userList.txt");
        if(!myFile1.exists()){
            try {
                myFile1.createNewFile();

            }catch (Exception e){
                System.out.println("Couldn't create file!");
            }
        }


        assertEquals(true,myFile.exists());
        assertEquals(true,myFile1.exists());


    }
}
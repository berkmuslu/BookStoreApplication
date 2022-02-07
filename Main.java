import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("(Default Customer Username:Password = user:test)"); //Default Username and Password
        createFiles(); //Creates needed files.

        Display obj = new Display();
        //Open the menu for user and started the program
        obj.menu();
    }


    private static void createFiles() {
        boolean first_time = false; //checks if files has values or not

        File myFile = new File("db/"); //creates a directory called db
        if (!myFile.exists()) {
            myFile.mkdirs();
        }

        myFile = new File("./db/userList.txt"); //creates a txt folder called userList
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./db/passList.txt"); //creates a txt folder called passList
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./db/bookList.txt"); //creates a txt folder called bookList
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./db/adminPassList.txt"); //creates a txt folder called adminPassList
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./db/adminList.txt"); //creates a txt folder called adminList
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        myFile = new File("./db/bookPurchased.txt"); //creates a txt folder called bookPurchased
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                first_time = true;
            } catch (Exception e) {
                System.out.println("Couldn't create file!");
            }
        }

        if (first_time) {
            try {
                FileWriter myFileWriter = new FileWriter("./db/userList.txt");
                myFileWriter.write("user"); //Writes user (our default username) to userLists.txt
                myFileWriter.close();

            } catch (IOException e) {
                System.out.println("Couldn't reach the file!");
            }

            try {
                FileWriter myFileWriter = new FileWriter("./db/adminList.txt");
                myFileWriter.write("admin"); //Writes admin (our default username) to adminList.txt
                myFileWriter.close();

            } catch (IOException e) {
                System.out.println("Couldn't reach the file!");
            }

            try {
                FileWriter myFileWriter = new FileWriter("./db/adminPassList.txt");
                myFileWriter.write("admin"); //Writes admin (our default password) to adminPassword.txt
                myFileWriter.close();

            } catch (IOException e) {
                System.out.println("Couldn't reach the file!");
            }

            try {
                FileWriter myFileWriter = new FileWriter("./db/passList.txt");
                myFileWriter.write("test"); //Writes test (our default password) to passList.txt
                myFileWriter.close();

            } catch (IOException e) {
                System.out.println("Couldn't reach the file!");
            }

            try {  //Writes our book infos (our default books) to bookList.txt
                FileWriter myFileWriter = new FileWriter("./db/bookList.txt");
                myFileWriter.write("Harry Potter\nJ.K. Rowling\n25\n55" +
                        "\nLord of The Rings\nJ.R.Tolkien\n29\n3" +
                        "\nLittle Prince\nAntoni de Saint Exupery\n12\n20" +
                        "\nHamlet\nWilliam Shakespeare\n20\n12" +
                        "\nWar and Peace\nLeo Tolstoy\n28\n4" +
                        "\nNorse Mythology\nNeil Gaiman\n16\n30" +
                        "\nLies That Bind Us\nAndrew Hart\n30\n14" +
                        "\nA Higher Loyalty: Truth Lies and Leadership\nJames Comey\n21\n12" +
                        "\nWhen Never Comes\nJBarbara Davis\n19\n12" +
                        "\nKaratay Diyeti\nProf.Dr.Canan Efendigil Karatay\n18\n19" +
                        "\nInferno\nDan Brown\n35\n12" +
                        "\nDa Vinci Code\nDan Brown\n35\n27" +
                        "\nMarvel Infinity War\n Jim Starlin\n38\n42" +
                        "\nBlack Beauty\nAnna Sewell\n22\n54" +
                        "\n1984\nGeorge Orwell\n22\n14" +
                        "\nThe Hunger Games\nSuzanne Collins\n30\n36" +
                        "\nSteve Jobs\nWalter Isaacson\n32\n51" +
                        "\nGame of Thrones\nGeorge R.R. Martin\n36\n63" +
                        "\nThe Girl With The Dragon Tattoo\nStieg Larsson\n24\n54" +
                        "\nThe Secret Teachings of All Ages\nManly P. Hal\n75\n62");
                myFileWriter.close();

            } catch (IOException e) {
                System.out.println("Couldn't reach the file!");
            }

        }


    }

}

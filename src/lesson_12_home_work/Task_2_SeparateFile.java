package lesson_12_home_work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task_2_SeparateFile {
    public static void main(String[] args) {
        String fullPathTo_User1_User2_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User1_User2.txt";
        String fullPathTo_User1_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User1.txt";
        String fullPathTo_User2_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User2.txt";

        File file = new File(fullPathTo_User1_User2_file);
        try(Scanner scanner = new Scanner(file);
            PrintWriter printWriterToUser1File = new PrintWriter(new FileOutputStream(fullPathTo_User1_file,true));
        ) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arrayFromLine = line.split(" ");
                for ( String str: arrayFromLine ) {
                        printWriterToUser1File.print(str);
                        printWriterToUser1File.print(" ");

                }
                printWriterToUser1File.print('\n');
            }

        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

}

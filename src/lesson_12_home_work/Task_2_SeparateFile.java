package lesson_12_home_work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task_2_SeparateFile {
    public static void main(String[] args) {
        //Прописываем пути к файлам
        String fullPathTo_User1_User2_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User1_User2.txt";
        String fullPathTo_User1_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User1.txt";
        String fullPathTo_User2_file = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "User2.txt";
        //Загружаем файл с первоначальным текстом
        File fileUser1User2 = new File(fullPathTo_User1_User2_file);
        //Проверяем есть ли файлы, если есть удаляем
        File fileUser1 = new File(fullPathTo_User1_file);
        File fileUser2 = new File(fullPathTo_User2_file);
        if (fileUser1.exists()) {
            fileUser1.delete();
        }
        if (fileUser2.exists()) {
            fileUser2.delete();
        }
        //Открываем потоки для чтения и записи
        try(Scanner scanner = new Scanner(fileUser1User2);
            PrintWriter printWriterToUser1File = new PrintWriter(new FileOutputStream(fullPathTo_User1_file,true));
            PrintWriter printWriterToUser2File = new PrintWriter(new FileOutputStream(fullPathTo_User2_file,true));
        ) {
                //Считываем весь файл
                String allText = scanner.useDelimiter("EOF").next();
                //Делим строку на массив используя как разделитель имена
                String[] allTextArray = allText.split("(?=User1:)|(?=User2:)");
            for ( String string : allTextArray ) {
                //Делим используя двоеточие
                String[] stringArray = string.split("(?=:)");
                //если first item User1 -> записываем всю строку в файл для User1
                if (stringArray[0].equals("User1")) {
                    printWriterToUser1File.print(string);
                }
                //если first item User2 -> записываем всю строку в файл для User2
                if (stringArray[0].equals("User2")) {
                    printWriterToUser2File.print(string);
                }
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}

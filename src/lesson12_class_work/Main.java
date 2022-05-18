package lesson12_class_work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        System.out.println("Lesson12");
        try (FileWriter fileWriter = new FileWriter("src" + File.separator +
                "lesson11_class_work_exception") {
        {catch (IOException e) {
            e.printStackTrace();
        }
}

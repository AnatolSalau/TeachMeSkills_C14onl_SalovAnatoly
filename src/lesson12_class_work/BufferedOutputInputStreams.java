package lesson12_class_work;

import java.io.*;
import java.util.Arrays;
//Byte oriented streams
class BufferedOutputInputStreams {
    public static void main(String[] args) {
        //Оборачиваем в стрим с буфером
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("src"
                        + File.separator + "lesson12_class_work" + File.separator + "input.txt"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                     new FileOutputStream("src"
                             + File.separator + "lesson12_class_work" + File.separator + "output.txt"))) {
            //C помощью метода available создаем нужной длины массив байт
            byte[] bytes = new byte[bufferedInputStream.available()];
            System.out.println(Arrays.toString(bytes));
            //Записываем в массив байты из файла
            bufferedInputStream.read(bytes);
            System.out.println(Arrays.toString(bytes));
            //Записываем в файл байты из массива
            bufferedOutputStream.write(bytes);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}

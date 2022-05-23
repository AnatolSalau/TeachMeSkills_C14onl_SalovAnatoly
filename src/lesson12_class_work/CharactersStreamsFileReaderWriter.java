package lesson12_class_work;

import java.io.*;

public class CharactersStreamsFileReaderWriter {
    public static void main(String[] args) {
        //Символьный стрим для чтения строк файлов
        // lineNumberReader имеет под копотом буфер
        // PrintWriter может работать с байтовыми потоками
        try(LineNumberReader lineNumberReader = new LineNumberReader(
                new FileReader("src"
                        + File.separator + "lesson12_class_work" +
                        File.separator + "input.txt"));
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream("src"
                            + File.separator + "lesson12_class_work" +
                            File.separator + "output.txt"));
        ) {
            //Прочтем одну строку
            String str = lineNumberReader.readLine();
            System.out.println(str);
            //запишем
            printWriter.println(str);
        } catch (IOException exc) {
            exc.getMessage();
        }
        //Создадим новый файл
        try {
            File file = new File(
                    "src"
                            + File.separator + "lesson12_class_work" +
                            File.separator + "newFile.txt"
            );
            //Проверим есть ли он или нет
            System.out.println(file.createNewFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

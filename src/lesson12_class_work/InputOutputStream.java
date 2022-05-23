package lesson12_class_work;

import java.io.*;
//Byte oriented streams
class InputOutputStream {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        //Открываем потом ввода
        try(InputStream inputStream = new FileInputStream("src"
                + File.separator + "lesson12_class_work" + File.separator + "input.txt")) {
            //Читаем один байт в цикле пока не дойдем до симфола переноса
            int ch = -1;
            while (ch != 10){
                ch = inputStream.read();
                stringBuilder.append((char)ch);
                System.out.print((char)ch);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        System.out.println(stringBuilder);
        //открываем поток вывода
        try(OutputStream outputStream = new FileOutputStream("src"
                + File.separator + "lesson12_class_work" + File.separator + "output.txt")) {
            char newChar = '0';
            for (int i = 0; i < stringBuilder.length(); i++) {
                newChar = stringBuilder.charAt(i);
                outputStream.write(newChar);
            }
        } catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}


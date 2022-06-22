package lesson_20_jdbc_homework.entity;

import java.io.*;

public class JpgPdfFile {
    private byte[] file;

    public JpgPdfFile(byte[] file) {
        this.file = file;
    }

    public JpgPdfFile(String nameFile) {
        file = loadImage("src" +
                File.separator + "lesson_20_jdbc_homework" +
                File.separator + "jpg_pdf" + File.separator + nameFile);
    }

    public byte[] getBytesFile() {
        return file;
    }

    private byte[] loadImage(String pathToImage) {
        byte[] result = null;
        try (FileInputStream fileInputStream = new FileInputStream(pathToImage)) {
            result = fileInputStream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveImageToDirectory(String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src" +
                File.separator + "lesson_20_jdbc_homework" +
                File.separator + "output" + File.separator + filename)) {
            fileOutputStream.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package lesson_17_classwork_reflecsion;

import java.io.IOException;
import java.io.InputStream;

public class WorkWithReflection_2 {
    public static void main(String[] args) {
        //Get current runtime (where is running current java program)
        Runtime runtime = Runtime.getRuntime();
        // .exec - выполняет  не в java программе а в операционной системе
        try {
            //compile .class
            Process process = runtime.exec("javac /Users/anatolysalov/JAVA/MyClass.java");
            // wait for - 0 - good, 1 - error
            int i = process.waitFor();
            System.out.println(i);
            switch (i) {
                case 0 -> {
                    String pathClass = "javac /Users/anatolysalov/JAVA/MyClass.class";
                    MyClassLoader classLoader = new MyClassLoader();
                    //Загружаем класс
                    Class<?> customClass = classLoader.loadClass("CustomClass");
                    //Создадим экземпляр
                    Object o = customClass.newInstance();

                }
                default -> {
                    //get error from runtime
                    try(InputStream inputStream = process.getErrorStream()) {
                        byte[] bytes = inputStream.readAllBytes();
                        System.out.println(new String(bytes));
                    }
                }
            }
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

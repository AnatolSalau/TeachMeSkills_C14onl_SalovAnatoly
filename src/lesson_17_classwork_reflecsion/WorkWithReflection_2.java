package lesson_17_classwork_reflecsion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

public class WorkWithReflection_2 {
    public static void main(String[] args) {
        //Get current runtime (where is running current java program)
        Runtime runtime = Runtime.getRuntime();
        // .exec - выполняет  не в java программе а в операционной системе
        try {
            //compile .class
            Process process = runtime.exec("javac src/lesson_17_classwork_reflecsion/CustomClass.java");
            // wait for - 0 - good, 1 - error
            int i = process.waitFor();
            System.out.println(i);
            switch (i) {
                case 0 -> {
                    String pathClass ="src/lesson_17_classwork_reflecsion/CustomClass.class";
                    MyClassLoader classLoader = new MyClassLoader();
                    //Ищем класс
                    classLoader.findClass("CustomClass",pathClass);
                    //Загружаем класс
                    Class<?> customClass = classLoader.loadClass("CustomClass");
                    //Создадим экземпляр
                    Object obj = customClass.newInstance();
                    System.out.println(obj);
                    //Get all methods and fields
                    Field[] allFields = customClass.getDeclaredFields();
                    System.out.println(Arrays.toString(allFields));
                    //Change private field
                    Arrays.stream(allFields)
                            .filter(field -> field.getName().toLowerCase().contains("value"))
                            .peek(field -> field.setAccessible(true))
                            .forEach(field -> setIntField(field, obj, 12));
                    //Check changes in field
                    Field[] allFieldsChanged = customClass.getDeclaredFields();
                    for (Field field: allFieldsChanged) {
                        field.setAccessible(true);
                        System.out.println(field.getInt(obj));
                    }
                    //Run private method
                    Method[] allMethods = customClass.getDeclaredMethods();
                    System.out.println(Arrays.toString(allMethods));
                    Arrays.stream(allMethods)
                            .filter(method -> method.getName().toLowerCase().contains("print"))
                            .peek(method -> method.setAccessible(true))
                            .forEach(method -> myInvoke(method, obj, "for method"));
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
    public static void myInvoke (Method method,Object obj, String str) {
        try {
            method.invoke(obj, str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void setIntField (Field field ,Object obj, int number) {
        try {
            field.setInt(obj, number);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

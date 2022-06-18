package lesson_17_classwork_reflecsion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WorkWithClassLoader {
    public static void main(String[] args) {
        String pathClass = "/Users/anatolysalov/JAVA/MyClass.class";
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            //Added class with class loader
            myClassLoader.findClass("MyClass",pathClass);
            Class<?> aClass = myClassLoader.loadClass("MyClass");
            System.out.println(aClass);
            //Create object from class
            Object o = aClass.newInstance();
            //get method with reflections
            Method[] allMethods = aClass.getDeclaredMethods();
            System.out.println(allMethods[0]);
            Method printFromMyClass = allMethods[0];
            //Start method
            printFromMyClass.invoke(o,"text added with reflection");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

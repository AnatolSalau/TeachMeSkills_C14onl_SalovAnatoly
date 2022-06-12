package lesson_17_classwork_reflecsion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

//Reflection with class in project
class WorkWithReflection_1 {
    public static void main(String[] args) {
        MyService myService = new MyService();
        //Get Class
        Class<? extends MyService> myServiceClass =  myService.getClass();
        //Get all methods
        Method[] methods  = myServiceClass.getMethods();
        for (Method me : methods) {
            System.out.println("Method:" + me);
        }
        //Get all fields
        Field[] fields = myServiceClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        try {
            //Get method through name
            Method method = myServiceClass.getDeclaredMethod("print");
            System.out.println("method: " + method);
            //Call private method
            method.setAccessible(true);
            System.out.println("method.invoke(myServiceClass):");
            method.invoke(myService);

            //Get annotation from field
            Field field = myService.getClass().getDeclaredField("sname");
            Annotation[] annotations = field.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));

        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
    }
}

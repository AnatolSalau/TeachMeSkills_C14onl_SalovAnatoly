package lesson_17_classwork_reflecsion;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//Custom ClassLoader
public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name,String path){
        try {
            //Read file
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            //Size file
            int available = fileInputStream.available();
            //empty array
            byte[] bytes = new byte[available];
            fileInputStream.read(bytes);
            //Enter class in our program
            //DefineClass ()
            return defineClass(name,bytes,0,available);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

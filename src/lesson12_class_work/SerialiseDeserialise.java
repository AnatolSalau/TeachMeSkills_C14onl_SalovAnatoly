package lesson12_class_work;

import javax.crypto.spec.PSource;
import java.io.*;

class SerialiseDeserialise {
    public static void main(String[] args) {
        User user = new User("Petsya",true);
        User userWithAdress = new User("Vanya",true,new Adress("Minsk"));
        //Для сериализации используем байтовые потоки
        try(
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(
                    "src" + File.separator + "lesson12_class_work" + File.separator + "date.txt"))
        ){
            dataOutputStream.write(65);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        //Поток для работы с объектами ObjectOutputStream,Сериализуем объекты
        try(
                ObjectOutputStream objectOutputStreamUser = new ObjectOutputStream(new FileOutputStream(
                        "src" + File.separator + "lesson12_class_work" + File.separator + "user.txt"));
                ObjectOutputStream objectOutputStreamAdress = new ObjectOutputStream(new FileOutputStream(
                        "src" + File.separator + "lesson12_class_work" + File.separator + "userWithAdress.txt"))
        ){
            //только для сериализуемых объектов (implements Serializable)
            objectOutputStreamUser.writeObject(user);
            objectOutputStreamAdress.writeObject(userWithAdress);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        //Десериализуем объекты из файла
        try (ObjectInputStream objectOutputStreamUser = new ObjectInputStream(new FileInputStream(
                "src" + File.separator + "lesson12_class_work" + File.separator + "user.txt"));
             ObjectInputStream objectInputStreamUserAdress = new ObjectInputStream(new FileInputStream(
                     "src" + File.separator + "lesson12_class_work" + File.separator + "userWithAdress.txt"))
        ){
            //Десериализуем User без адреса
            Object someObjectUser = objectOutputStreamUser.readObject();
            //Проверяем user или нет и вызываем tostring
            if (someObjectUser instanceof User) {
                User newUser = (User) someObjectUser;
                System.out.println(newUser.toString());
                System.out.println(newUser.age);
            }
            //Десериализуем User c адресом
            //Все вложенные классы в классе тоже должны быть сериализуемыми
            //Или помеченными trancient - что это поле не надо сериализовать
            Object someObjectUserAdress = objectInputStreamUserAdress.readObject();
            //Проверяем userAdree или нет и вызываем tostring
            if (someObjectUserAdress instanceof User) {
                User newUser = (User) someObjectUserAdress;
                System.out.println(someObjectUserAdress.toString());
            }
         }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }



    }
}

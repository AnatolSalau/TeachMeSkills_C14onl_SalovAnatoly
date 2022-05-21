package lesson_12_home_work;

import java.io.File;

class Task_1_SerialiseDeserialise {
    public static void main(String[] args) {
        String fullPathToFile = "src" + File.separator + "lesson_12_home_work" + File.separator +
                "someObject.txt";
        User user = new User("Anatoly",32,Sex.MALE);
        User newUser = null;
        if(SerializingUser.serializeUser(user,fullPathToFile)) {
            newUser = DeserializingUser.deserializeUser(fullPathToFile);
        } else {
            System.out.println("Читаем исключение в консоле");
        }
        if (newUser != null) {
            newUser.printToString();
        } else {
            System.out.println("Читаем исключение в консоле");
        }
    }
}

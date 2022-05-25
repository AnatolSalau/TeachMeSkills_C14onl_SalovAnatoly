package lesson_12_home_work;

import java.io.*;

class DeserializingUser {
    public static User deserializeUser(String fullPathToFile) {
        User result = null;
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(fullPathToFile))
        ) {
            Object someObject = objectInputStream.readObject();
            if (someObject instanceof User) {
                result = (User) someObject;
            }
        } catch (ClassNotFoundException | IOException exc) {
            exc.printStackTrace();
        } finally {
            return result;
        }
    }
}

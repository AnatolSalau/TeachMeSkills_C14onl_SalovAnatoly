package lesson_12_home_work;

import java.io.*;

class SerializingUser {
    public static boolean serializeUser(User user, String fullPathToFile) {
        boolean result = false;
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(fullPathToFile))
        ) {
            objectOutputStream.writeObject(user);
            result = true;
        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            return result;
        }
    }
}

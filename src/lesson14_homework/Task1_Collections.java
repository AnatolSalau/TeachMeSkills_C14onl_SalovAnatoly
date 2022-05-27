package lesson14_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class Task1_Collections {
    public static void main(String[] args) {
        //Создаем ArrayList
        ArrayList<User> listUsers = new ArrayList<User>(
                Arrays.asList(
                        new User("CThird", Gender.MALE,20),
                        new User("CThird", Gender.MALE,20),
                        new User("AFirst", Gender.MALE,20)
                )
        );


    }
}

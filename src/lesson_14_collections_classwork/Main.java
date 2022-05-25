package lesson_14_collections_classwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        Collections.sort(users, UserComparator);
    }
}

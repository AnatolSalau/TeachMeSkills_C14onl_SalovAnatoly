package lesson_14_collections_classwork;

import java.util.ArrayList;
import java.util.Collections;

//Сортировка объеквтов Collections.sort с помощью Comparator
class CollectionsSortUsers {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(30,"C_Third"));
        users.add(new User(30,"A_Third_First"));
        users.add(new User(25,"B_Second"));
        users.add(new User(20,"F_Second"));
        users.add(new User(20,"A_First"));
        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + users);
        Collections.sort(users,new UserComparatorAge());
        System.out.println("List before the use of" +
                " Collection.sort() Age :\n" + users);
        Collections.sort(users,new UserComparatorAge().thenComparing(new UserComparatorName()));
        System.out.println("List before the use of" +
                " Collection.sort() Age plus Name :\n" + users);
    }
}

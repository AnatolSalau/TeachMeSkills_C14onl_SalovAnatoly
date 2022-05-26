package lesson_14_collections_classwork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IterateCollections_Iterable {
    public static void main(String[] args) {
     //Сортировка объектов TreeSet с помощью Comparator
       Set<User> users = new TreeSet<User>(
               new UserComparatorAge().thenComparing(new UserComparatorName()));
        users.add(new User(30,"Ccccccc"));
        users.add(new User(30,"Bbbbb"));
        users.add(new User(25,"Aaaa"));
        System.out.println(users);
    //Перебор с помощью foreach
     for (User user: users) {
     System.out.println(user.getName());
     }
     //Перебор с помощью Iterator
        Iterator<User> iterator = users.iterator();
     while (iterator.hasNext()) {
         User next = iterator.next();
         System.out.println(next);
     }


    }
}

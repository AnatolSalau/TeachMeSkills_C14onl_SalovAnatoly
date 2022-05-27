package lesson_14_collections_classwork;

import java.util.*;

class DifferenceBetween_HashSet_TreeSet {
    public static void main(String[] args) {
     //Сортировка объектов TreeSet с помощью Comparator
       Set<User> users = new TreeSet<User>(
               new UserComparatorAge().thenComparing(new UserComparatorName()));
        users.add(new User(30,"C_Third"));
        users.add(new User(30,"A_Third_First"));
        users.add(new User(25,"B_Second"));

        System.out.println(users);
     //HashSet автоматически сортирует объекты в зависимости от возвращаемого значения hashCode
     //HashSet ищет только дубликаты
        Set<UserCumtomHash> usersHash = new HashSet<>();
        usersHash.add(new UserCumtomHash(30,"C_Third"));
        usersHash.add(new UserCumtomHash(30,"A_Third_First"));
        usersHash.add(new UserCumtomHash(25,"B_Second"));
        usersHash.add(new UserCumtomHash(20,"F_Second"));
        usersHash.add(new UserCumtomHash(20,"A_First"));
        System.out.println(usersHash);
    }
}

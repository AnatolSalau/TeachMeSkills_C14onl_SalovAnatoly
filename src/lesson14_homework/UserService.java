package lesson14_homework;

import java.util.*;

public class UserService {
    //поиск по имени для листов
    public static List<User> findAllUsersWithName(List<User> list, String name) {
        List<User> result = new LinkedList<>();
        for (User user : list) {
            if (user.getName().equals(name)) {
                result.add(user);
            }
        }
        //Сортируем на основе Comparable
        Collections.sort(result);
        return result;
    }

    //поиск по имени для множеств
    public static Set<User> findAllUsersWithName(Set<User> set, String name) {
        Set<User> result = new TreeSet<>();
        for (User user : set) {
            if (user.getName().equals(name)) {
                result.add(user);
            }
        }
        return result;
    }

    //поиск по полу для листов
    public static List<User> findAllUsersWithGender(List<User> list, Gender gender) {
        List<User> result = new LinkedList<>();
        for (User user : list) {
            if (user.getGender().equals(gender)) {
                result.add(user);
            }
        }
        //Сортируем на основе Comparable
        Collections.sort(result);
        return result;
    }

    //поиск по полу для множеств
    public static Set<User> findAllUsersWithGender(Set<User> list, Gender gender) {
        Set<User> result = new TreeSet<>();
        for (User user : list) {
            if (user.getGender().equals(gender)) {
                result.add(user);
            }
        }
        return result;
    }

    //сортировка по возрасту для листов
    public static List<User> getSortedCollection(List<User> list) {
        List<User> result = null;
        //Сортируем
        Collections.sort(list);
        result = list;
        return result;
    }

    //сортировка по возрасту для множеств
    public static Set<User> getSortedCollection(Set<User> set) {
        //Оборачиваем в TreeSet - если к нам попало HashSet то оно отсортируется
        Set<User> result = new TreeSet<>(set);
        return result;
    }
}

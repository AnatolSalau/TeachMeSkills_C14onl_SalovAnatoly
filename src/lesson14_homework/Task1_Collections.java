package lesson14_homework;

import java.util.*;

class Task1_Collections {
    public static void main(String[] args) {
        //Создаем ArrayList, Убрал лишнюю обертку для созданрия листа согласно замечанию
        List<User> arrayListUsers = Arrays.asList(
                        new User("C", Gender.MALE, 20),
                        new User("B", Gender.FEMALE, 25),
                        new User("A", Gender.MALE, 30),
                        new User("A", Gender.MALE, 20)
        );
        //Cоздаем linkedList
        List<User> linkedListUsers = new LinkedList<>(
                Arrays.asList(
                        new User("C", Gender.MALE, 20),
                        new User("B", Gender.FEMALE, 25),
                        new User("B", Gender.MALE, 20),
                        new User("A", Gender.FEMALE, 20)
                )
        );
        //Создаем HashSet
        Set<User> hashSetUsers = new HashSet<>(
                Arrays.asList(
                        new User("C", Gender.MALE, 20),
                        new User("C", Gender.FEMALE, 28),
                        new User("B", Gender.MALE, 25),
                        new User("A", Gender.FEMALE, 20)
                )
        );
        //Создаем TreeSet
        Set<User> treeSetUsers = new TreeSet<>(
                Arrays.asList(
                        new User("C", Gender.MALE, 20),
                        new User("B", Gender.FEMALE, 25),
                        new User("A", Gender.MALE, 20),
                        new User("D", Gender.FEMALE, 35),
                        new User("D", Gender.MALE, 20)
                )
        );
        //Ищем пользователей по именам учитывая дубликаты
        System.out.println("arrayListUsers:");
        System.out.println(UserService.findAllUsersWithName(arrayListUsers, "A"));
        System.out.println("linkedListUsers:");
        System.out.println(UserService.findAllUsersWithName(linkedListUsers, "B"));
        System.out.println("linkedListUsers:");
        System.out.println(UserService.findAllUsersWithName(hashSetUsers, "C"));
        System.out.println("treeSetUsers:");
        System.out.println(UserService.findAllUsersWithName(treeSetUsers, "D"));
        //Ищем пользователей по полу
        System.out.println(UserService.findAllUsersWithGender(arrayListUsers, Gender.MALE));
        System.out.println(UserService.findAllUsersWithGender(linkedListUsers, Gender.MALE));
        System.out.println(UserService.findAllUsersWithGender(hashSetUsers, Gender.FEMALE));
        System.out.println(UserService.findAllUsersWithGender(treeSetUsers, Gender.FEMALE));
        //Получаем отсортированную коллекцию по возрасту

        System.out.println(UserService.getSortedCollection(arrayListUsers));
        System.out.println(UserService.getSortedCollection(linkedListUsers));
        System.out.println(UserService.getSortedCollection(hashSetUsers));
        System.out.println(UserService.getSortedCollection(treeSetUsers));
    }
}

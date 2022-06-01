package lesson_15_classwork_lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExeptionAndFinal {
    public static void main(String[] args) {
        //Лямбда может кидать только непроверяемые исключения
        Predicate<User> validForSave = user -> validSave(user);
        Predicate<User> validForDelete = user -> validDelete(user);
        Predicate<User> validForAdd= user -> validAdd(user);
        User user = new User("Anatoly", 30);
        Consumer<User> changeUser= us -> {
            //Переменные в лямбде должны быть final или effectiveFinal
//            user = new User("Dima", 35);
        };

    }
    private static boolean validSave(User user) {
        int maxLength = 2;
        if (user == null) {
            //Только непроверяемые исключения
            throw new RuntimeException();
        }
        return user.getName() != null && user.getName().length() > maxLength;
    }
    private static boolean validDelete(User user) {
        int maxLength = 2;
        if (user == null) {
            //Проверяемы исключения должны быть обработаны или обернуты в непроверяемые
            //исключения
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return user.getName() != null && user.getName().length() > maxLength;
    }
    private static boolean validAdd(User user) {
        int maxLength = 2;
        if (user == null) {
            //Если мы не знаем как обработать проверяемое исключение
            //Мы должны кинуть выше непроверяемое
            try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                //Кидаем выше непроверяемое исключение
                throw new RuntimeException(e);
            }
        }
        return user.getName() != null && user.getName().length() > maxLength;
    }
}

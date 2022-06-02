package lesson_15_classwork_lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

class LambdaLesson3 {
    public static void main(String[] args) {
        int maxLength = 2;
        User user = new User("Anatoly",32, 242569989365L);
        UserService userService = new UserService();
        //Две реализации predicate
        //Лямбда видит все что есть выше в методе
        Predicate<User> validForSave = us -> us.getName() != null && us.getName().length() > maxLength;
        Predicate<User> validForDelete = us -> us.getId() > 0;
        //Вынесем реализацию лямбды в отдельный метод
        Predicate<User> validForUpdate = us -> valid(us);
        // Две имплементации consumer
        Consumer<User> save = us -> System.out.println("Save user:" + us);
        Consumer<User> del = us -> System.out.println("Delete user:" + us);
        //Используем
        userService.processUser(user, validForSave, save);
    }
    static boolean valid(User us) {
        return  us.getName() != null &&
                us.getName().length() > 2 &&
                us.getId() != 0 ;
    }
}

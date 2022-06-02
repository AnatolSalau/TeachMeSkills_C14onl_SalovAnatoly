package lesson_15_classwork_lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserService {
    //Проверяем юзера и что то с ним делаем используя  функциональные интрефейсы
    void processUser (User user, Predicate<User> valid, Consumer<User> process) {
        if (valid.test(user)) {
            process.accept(user);
        } else {
            System.out.println("User is not value");
        }
    }
}

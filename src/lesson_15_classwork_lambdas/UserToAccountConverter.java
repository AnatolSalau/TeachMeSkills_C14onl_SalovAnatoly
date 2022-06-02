package lesson_15_classwork_lambdas;

import java.util.function.Function;

public class UserToAccountConverter {
    //Метод для конвертирования юсера в аккаунт
    Account convert (User user, Function<User,Account> convert) {
        //Используем готовый метод apply интерфейса Function
        return convert.apply(user);
    }
}

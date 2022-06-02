package lesson_15_classwork_lambdas;

public class LambdaCastObject {
    public static void main(String[] args) {
        User user = new User("Anatoly", 32,1234567);
        UserToAccountConverter converter = new UserToAccountConverter();
        //Конвертируем user в account
        Account account = converter.convert(user,us -> {
            return new Account(us.getName(), us.getId());
            }
        );
        //Укороченная запись конвертации
        Account account2 = converter.convert(user,us ->
                     new Account(us.getName(), us.getId())
        );
        System.out.println(user);
        System.out.println(account);
    }
}

package lesson_15_classwork_lambdas;

public class LambdaCastObject {
    public static void main(String[] args) {
        User user = new User("Anatoly", 32);
        UserToAccountConverter converter = new UserToAccountConverter();

        Account account = converter.convert(user,us -> {
            return new Account(us.getName(), us.getId());
            }
        );
        System.out.println(user);
        System.out.println(account);
    }
}

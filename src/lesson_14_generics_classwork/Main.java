package lesson_14_generics_classwork;

public class Main {
    public static void main(String[] args) {
        DBService<User,Long> userService = new UserDBService();
        DBService<Car,String> carSevice = new CarDBService();


        User user = new User(30,"Vasya");
        Car car = new Car("BMV");
        TestService testService = new TestService();
        User user1 = testService.get(user);
        Car car1 = testService.get(car);
        System.out.println(user1);
        System.out.println(car1);

    }
}

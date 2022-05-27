package lesson_14_generics_classwork;

public class GenericMetodClass {
    public static void main(String[] args) {
        DBService<User,Long> userService = new UserDBService();
        DBService<Car,String> carSevice = new CarDBService();
        User user = new User(30,"Vasya");
        Car car = new Car("BMV");
        TestService testService = new TestService();
        User user1 = testService.get(user);
        //Можно указывать тип передаваемый
        Car car1 = testService.<Car>get(car);
        //Необходимо указать передаваемый тип
        System.out.println(testService.<User>get(user));
        System.out.println(user1);
        System.out.println(car1);




    }
}

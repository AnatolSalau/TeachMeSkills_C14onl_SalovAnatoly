package lesson11_class_work_exception;

public class Main {
    public static void main(String[] args) {
        User user = new User("Petsya", 5);
        /*
        * Создание собственных исключений и наследование исключения от исключения*/
        UserValidationService service = new UserValidationService();
        try {
            service.validate(user);
        } catch (UserNameValidationException ex) {
//            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (UserAgeValidationException ex) {
//            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("Print One");
/*
* ---------------------------------------------------------------------------*/
        DBService dbService = new DBService();
        dbService.save(user);
        System.out.println("Print Two");
        try {
            dbService.saveWithThrows(user);
        }  catch (DBExeption ex) {
            System.out.println("Error in database");
            ex.printStackTrace();
        }
       System.out.println("Print Three");

    }
}

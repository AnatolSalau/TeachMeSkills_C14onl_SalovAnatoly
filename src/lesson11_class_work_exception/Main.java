package lesson11_class_work_exception;

public class Main {
    public static void main(String[] args) {
//        Наследование исключений
        User user = new User("",32);
        UserValidationService service = new UserValidationService();
        try {
            service.validate(user);
        } catch (UserAgeValidationException exc) {
            System.out.println(exc.getMessage());
        } catch (UserNameValidationException exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println("PrintOne");
//-------------------------------------------------
//        Метод без throws - програма продолжает работать
        DBService dbService = new DBService();
        dbService.save(user);
        System.out.println("PrintTwo");
//        ------------------------------------------
//       Метод кидающий ошибку
        try {
            dbService.saveWithThrows(user);
        } catch(DBExeption ex) {
            System.out.println("Error in database");
            ex.toString();
        }
        System.out.println("PrintThree");
//--------------------------------------------------
        DBRepository dbRepository = new DBUserRepositoryService();
        try {
            dbRepository.save(user);
            dbRepository.delete(user);
        } catch (DBExeption ex) {
            ex.toString();
        }
        System.out.println("PrintThree");
    }
}

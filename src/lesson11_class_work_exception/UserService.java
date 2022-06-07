package lesson11_class_work_exception;

class UserService {
    void save(User user) throws DBExeption {
        DBService service = new DBService();
        service.save(user);
    }

    void saveDBrepository(User user, DBRepository dbRepository) {
        try {
            dbRepository.save(user);
        } catch (TestDBExeption ex) {
            ex.toString();
        } catch (DBExeption ex) {
            ex.toString();
        }

    }
}

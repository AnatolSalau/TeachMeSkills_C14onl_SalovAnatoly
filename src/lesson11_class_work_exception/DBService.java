package lesson11_class_work_exception;

class DBService {
    void save(User user) {
        try {
            throw new DBExeption();
        } catch (DBExeption ex) {
            System.out.println("Can't save");
        }
    }
    void saveWithThrows(User user)  throws DBExeption{
        throw new DBExeption();
    }
}

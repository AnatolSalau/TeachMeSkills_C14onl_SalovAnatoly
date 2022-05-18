package lesson11_class_work_exception;

import lesson11_class_work_exception.User;

public interface DBRepository {
    void save() throws DBExeption;
    void save(User user) throws DBExeption;

    void delete(User user) throws DBExeption;
}

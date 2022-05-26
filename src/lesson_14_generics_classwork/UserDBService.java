package lesson_14_generics_classwork;
//реализуем интерфейс с дженериками
class UserDBService implements DBService<User,Long> {
    @Override
    public void save(User entry) {
    }

    @Override
    public void delete(User entry) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User update(User entry) {
        return null;
    }
}

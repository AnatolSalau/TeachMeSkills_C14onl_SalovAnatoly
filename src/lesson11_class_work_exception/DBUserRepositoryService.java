package lesson11_class_work_exception;

class DBUserRepositoryService implements DBRepository {
    @Override
    public void save(User user) throws DBExeption {
        throw  new DBExeption(user);
    }

    @Override
    public void delete(User user) throws DBExeption {
        throw  new DBExeption(user);
    }

    @Override
    public void save() throws DBExeption {
        throw new TestDBExeption(new User("TestUser",20));
    }
}

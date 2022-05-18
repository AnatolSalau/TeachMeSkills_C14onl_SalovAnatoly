package lesson11_class_work_exception;

public class DBExeption  extends Exception{
    private User user;

    public DBExeption(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user + super.toString();
    }
}

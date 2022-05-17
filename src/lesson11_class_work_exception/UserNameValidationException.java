package lesson11_class_work_exception;

public class UserNameValidationException extends UserValidationException{
    public UserNameValidationException(User user) {
        super(user, "User name is not valid");
    }
}

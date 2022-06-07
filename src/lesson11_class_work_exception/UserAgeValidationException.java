package lesson11_class_work_exception;

public class UserAgeValidationException extends UserValidationException{
    public UserAgeValidationException(User user) {
        super(user, "Users's age is not correct");
    }
}

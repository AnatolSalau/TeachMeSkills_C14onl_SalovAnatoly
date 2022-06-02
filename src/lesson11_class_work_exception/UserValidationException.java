package lesson11_class_work_exception;

public class UserValidationException extends RuntimeException {
    private User user;

    public UserValidationException(User user, String message) {
        super(message);
        this.user = user;
    }

    @Override
    public String getMessage() {
        return "Exception. User is not correct: "+ super.getMessage() +" " + user;
    }
}

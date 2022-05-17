package lesson11_class_work_exception;

public class UserValidationService {
    public void validate(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            throw new UserNameValidationException(user);
        } else if (user.getAge() < 18) {
            throw new UserAgeValidationException(user);
        } else {
            System.out.println("User is valid");
        }

    }
}

package lesson_20_jdbc.exeption;

public class CarValidationExeption extends RuntimeException {
    //Конструктор для вывода сообщения
    public CarValidationExeption(String message) {
        super(message);
    }
}

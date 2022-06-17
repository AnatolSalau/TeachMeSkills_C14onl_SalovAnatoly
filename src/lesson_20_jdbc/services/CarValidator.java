package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Car;
import lesson_20_jdbc.entity.TypeValid;
import lesson_20_jdbc.exeption.CarValidationExeption;

import java.util.concurrent.CancellationException;

public class CarValidator implements Vaidator<Car> {
    @Override
    public void validate(Car car, TypeValid typeValid) throws CancellationException {
            if (car.getNumber() == null || car.getNumber().isEmpty()) {
                throw new CarValidationExeption("number must be filled");
            }
            if (car.getBrand() == null) {
                throw new CarValidationExeption("brand is requared");
            }
            if (car.getAge() < 0) {
                car.setAge(0);
            }
            if (typeValid == TypeValid.SAVE) {
                if (car.getId() != null) {
                    throw new CarValidationExeption("id must be null");
            }
            if (typeValid == TypeValid.UPDATE){
                if (car.getId() == null) {
                    throw new CarValidationExeption("id can't be null for update");
                }
            }
        }
    }
}

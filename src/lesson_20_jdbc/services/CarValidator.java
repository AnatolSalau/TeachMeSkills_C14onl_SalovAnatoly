package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Car;
import lesson_20_jdbc.entity.TypeValid;

import java.util.concurrent.CancellationException;

public class CarValidator implements Vaidator<Car> {
    @Override
    public void validate(Car entity, TypeValid typeValid) throws CancellationException {

    }
}

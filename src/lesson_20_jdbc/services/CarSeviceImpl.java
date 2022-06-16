package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Brand;
import lesson_20_jdbc.entity.Car;

import java.sql.Connection;
import java.util.List;

public class CarSeviceImpl implements CarService{

    private Connection connection;
    private CarValidator carValidator;

    public CarSeviceImpl(Connection connection, CarValidator carValidator) {
        this.connection = connection;
        this.carValidator = carValidator;
    }

    @Override
    public void save(Car car) {
        Car
    }

    @Override
    public Car get(Integer id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public List<Car> getByBrand(Brand bran) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Car car) {

    }
}

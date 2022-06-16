package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Brand;
import lesson_20_jdbc.entity.Car;

import java.sql.*;
import java.util.List;

public class CarSeviceImpl implements CarService{

    private Connection connection;
    private CarValidator carValidator;
    public static final String SAVE ="insert into cars (number, brand, age) " +
            "values (?,?,?) ";
    public static final String GET_ID = "select max(id) + 1 as id from cars";

    public CarSeviceImpl(Connection connection, CarValidator carValidator) {
        this.connection = connection;
        this.carValidator = carValidator;
    }

    @Override
    public void save(Car car) {
        String number = car.getNumber();
        String brand = car.getBrand().name();
        int age = car.getAge();

        PreparedStatement preparedStatement = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ID);

            preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1,number);
            preparedStatement.setString(2,brand);
            preparedStatement.setInt(3,age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

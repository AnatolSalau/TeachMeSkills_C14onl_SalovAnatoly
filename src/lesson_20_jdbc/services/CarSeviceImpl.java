package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Brand;
import lesson_20_jdbc.entity.Car;
import lesson_20_jdbc.entity.TypeValid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarSeviceImpl implements CarService{

    private Connection connection;
    private CarValidator carValidator;
    public static final String SAVE ="insert into cars (id, number, brand, age) " +
            "values (?,?,?,?) ";
    //получаем max id и добавляем единицу
    public static final String GET_ID = "select max(id) + 1 as id from cars";

    public static final String UPDATE = "update cars set number = ?, brand = ?, age = ? where id = ?";

    public CarSeviceImpl(Connection connection, CarValidator carValidator) {
        this.connection = connection;
        this.carValidator = carValidator;
    }

    @Override
    public void save(Car car) {
        carValidator.validate(car, TypeValid.SAVE);

        String number = car.getNumber();
        String brand = car.getBrand().name();
        int age = car.getAge();

        PreparedStatement preparedStatement = null;
        try {
            Statement statement = connection.createStatement();
            // GET_ID = "select max(id) + 1 as id from cars";
            ResultSet resultSet = statement.executeQuery(GET_ID);
            /* id по умолчанию равно 0*/
            int next_id = 0;
            /*проверяем есть ли id, если нету то сохраняем с id 0*/
            if (resultSet.next()) {
                /* если id eсть - увеличиваем его на 1*/
                next_id = resultSet.getInt("id");
            }
            //Сохраняем
            //SAVE ="insert into cars (id, number, brand, age) values (?,?,?,?) ";
            preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setInt(1,next_id);
            preparedStatement.setString(2,number);
            preparedStatement.setString(3,brand);
            preparedStatement.setInt(4,age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Car get(Integer id) {
        Car car = null;
        if (id != null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("select * from cars where id = ?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int dbId = resultSet.getInt("id");
                    String number = resultSet.getString("number");
                    String brand = resultSet.getString("brand");
                    int age = resultSet.getInt("age");
                    //enum.valueOf(String) - возвращает ENUM по строке
                    car = new Car(dbId,number, Brand.valueOf(brand), age);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();

        try {
            //Prepare statement можно использовать с запросами без ?
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from cars");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int dbId = resultSet.getInt("id");
                String number = resultSet.getString("number");
                String brand = resultSet.getString("brand");
                int age = resultSet.getInt("age");
                //enum.valueOf(String) - возвращает ENUM по строке
                Car car = new Car(dbId,number, Brand.valueOf(brand), age);
                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public List<Car> getByBrand(Brand brand) {
        Car car = null;
        List<Car> cars = new ArrayList<>();
        if (brand != null) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("select * from cars where brand = ?");
                preparedStatement.setString(1, brand.name());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int dbId = resultSet.getInt("id");
                    String number = resultSet.getString("number");
                    String dbBrand = resultSet.getString("brand");
                    int age = resultSet.getInt("age");
                    //enum.valueOf(String) - возвращает ENUM по строке
                    car = new Car(dbId,number, Brand.valueOf(dbBrand), age);
                    cars.add(car);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }

    @Override
    public void delete(Integer id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from cars where id = " + id);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {
        carValidator.validate(car, TypeValid.UPDATE);

        Integer id = car.getId();
        String number = car.getNumber();
        String brand = car.getBrand().name();
        int age = car.getAge();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(4,id);
            preparedStatement.setString(1,number);
            preparedStatement.setString(2,brand);
            preparedStatement.setInt(3,age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

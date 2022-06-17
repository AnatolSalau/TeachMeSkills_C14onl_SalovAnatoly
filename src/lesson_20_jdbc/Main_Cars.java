package lesson_20_jdbc;

import lesson_20_jdbc.entity.Brand;
import lesson_20_jdbc.entity.Car;
import lesson_20_jdbc.services.CarService;
import lesson_20_jdbc.services.CarSeviceImpl;
import lesson_20_jdbc.services.CarValidator;
import lesson_20_jdbc.services.InitService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main_Cars {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/lesson20_jdbc";
        String user = "postgres";
        String password = "sA#259979148307";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
            InitService service = new InitService(connection);
            service.init();

            Car carAdd = new Car("dassd",Brand.AUDI,10);

            CarService carService = new CarSeviceImpl(connection, new CarValidator());
            carService.save(carAdd);

            Car car = carService.get(3);
            System.out.println(car);

            List<Car> allCars = carService.getAll();
            System.out.println(allCars);

            carService.delete(3);

            Car carUpdate = new Car(2,"00002by", Brand.VOLVO, 20);
            carService.update(carUpdate);

            List<Car> carByBrand = carService.getByBrand(Brand.VOLVO);
            System.out.println(carByBrand);
            //Connection и statements нужно закрывать
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

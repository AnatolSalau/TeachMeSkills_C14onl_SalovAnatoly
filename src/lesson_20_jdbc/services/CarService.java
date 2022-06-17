package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.Brand;
import lesson_20_jdbc.entity.Car;

import java.util.List;

public interface CarService {
    /*
    * CRUD service
    * Create
    * Read
    * Update
    * Delete
    * */
    void save (Car car);
    Car get(Integer id);
    List<Car> getAll();
    List<Car> getByBrand(Brand bran);
    void delete(Integer id);
    void update(Car car);
}

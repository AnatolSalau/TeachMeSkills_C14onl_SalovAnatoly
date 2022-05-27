package lesson_14_generics_classwork;
//реализуем интерфейс с дженериками
public class CarDBService implements DBService<Car,String>{
    @Override
    public void save(Car entry) {

    }

    @Override
    public void delete(Car entry) {

    }

    @Override
    public Car getUser(String id) {
        return null;
    }

    @Override
    public Car update(Car entry) {
        return null;
    }
}

package lesson_14_generics_classwork;

class TestService {
    void save(User user) {
    }
    //Создаем метод с помощью дженериков
    <T> T get(T type) {
        return type;
    }
    <U,T> T getObject(U object) {
        T result = null;
        return result;
    }
}

package lesson_14_generics_classwork;
//Создаем интерфейс с помощью generic
interface DBService<T,U> {
    void save(T entry);
    void delete(T entry);
    T getUser(U id);
    T update (T entry);
}

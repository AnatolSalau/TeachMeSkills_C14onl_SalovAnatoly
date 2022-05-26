package lesson_14_generics_classwork;
//Создаем интерфейс с помощью generic
//Ограничиваем с помощью наследования
/*Создаем интерфейс который должен работать с типом,
* который является наследником Сl2
* */
/*
*interface DBServiceExtend<T,U extends Cl2, E, L extends Number> {
* */
interface DBServiceExtend<T,U extends Cl2> {
    void save(T entry);
    void delete(T entry);
    T getUser(U id);
    T update (T entry);
}

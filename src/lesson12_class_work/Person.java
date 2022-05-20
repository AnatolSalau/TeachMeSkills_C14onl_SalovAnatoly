package lesson12_class_work;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    //Для сериализации у родителя должен быть пустой конструктор
    //Без пустого конструктора нельзя сериализовать
    //Или родитель тоже должен быть Serializible
    public Person() {
        this.name = "Person";
        System.out.println(name);
    }

    public Person(String name) {
        this.name = name;
    }
}

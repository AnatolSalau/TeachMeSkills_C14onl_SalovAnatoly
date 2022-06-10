package lesson_17_classwork;

public class Dog extends Animal {
    private int age;
    final String type = "Dog";

    public Dog(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

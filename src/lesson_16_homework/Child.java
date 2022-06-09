package lesson_16_homework;

import java.util.Objects;

class Child {
    private String name;
    private int age;
    private SEX sex;

    enum SEX {
        MAN, WOMAN
    }

    public Child(String name, int age, SEX sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return age == child.age && Objects.equals(name, child.name) && sex == child.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public SEX getSex() {
        return sex;
    }
}

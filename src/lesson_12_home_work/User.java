package lesson_12_home_work;

import java.io.Serializable;

class User implements Serializable {
    private String name;
    private int age;
    private Sex sex;

    public User(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

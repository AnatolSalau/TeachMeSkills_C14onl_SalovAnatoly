package lesson14_homework;

import java.util.Objects;

class User implements Comparable<User> {
    private String name;
    private Gender gender;
    private int age;

    public User(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age);
    }

    @Override
    public int compareTo(User user) {
        if (user.getAge() == this.age) {
            //Если возрасты равны будем проверять по первой букве
            //Берем код ASCII первых букв
            //Код первой буквы текущего обьекта
            int codeCurrent = this.name.charAt(0);
            //Код первой буквы внешнего обьекта
            int codeExternal = user.getName().charAt(0);
            //возвращаем результат вычитания
            return codeCurrent - codeExternal;
        } else if (user.getAge() > this.age) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + gender +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

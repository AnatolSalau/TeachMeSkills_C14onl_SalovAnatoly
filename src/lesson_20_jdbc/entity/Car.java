package lesson_20_jdbc.entity;

public class Car {
    private Integer id;
    private String number;
    private Brand brand;
    private int age;

    public Car() {
    }

    public Car(Integer id, String number, Brand brand, int age) {
        this.id = id;
        this.number = number;
        this.brand = brand;
        this.age = age;
    }

    public Car(String number, Brand brand, int age) {
        this.id = null;
        this.number = number;
        this.brand = brand;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", brand=" + brand +
                ", age=" + age +
                '}';
    }
}

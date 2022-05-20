package lesson12_class_work;

import java.io.Serializable;

class User extends Person implements Serializable {
    private String name;
    private boolean sex;
    //Статика не сериализуется,
    // подтянется из класса юзер которрый будет загружен
    public static Integer age = 20;
    private transient Adress adress;

    public User(String name, boolean sex, Adress adress) {
        this.name = name;
        this.sex = sex;
        this.adress = adress;
        System.out.println("Full constructor");
    }

    public User(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
        this.adress = null;
    }

    public static Integer getAge() {
        return age;
    }

    public static void setAge(Integer age) {
        User.age = age;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", adress=" + adress +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}

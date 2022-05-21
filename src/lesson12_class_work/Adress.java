package lesson12_class_work;

import java.io.Serializable;

public class Adress implements Serializable {
    private String city;

    public Adress(String city) {
        this.city = city;
    }

    public Adress() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                '}';
    }
}

package lesson_15_classwork_lambdas;

import java.util.Locale;

public class Account {
    private String name;
    private long id;
    private  String password;

    public Account(String name, long id) {
        this.name = name;
        this.id = id;
        this.password = name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}

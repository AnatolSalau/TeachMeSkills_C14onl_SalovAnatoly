package lesson_20_jdbc.services;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitService {
    private Connection connection;
    public static final String CREATE = "create table if not exists cars (id int primary key, number varchar, brand varchar, age int )";

    public InitService(Connection connection) {
        this.connection = connection;
    }

    public void init() {

        try {
            Statement statement = connection.createStatement();
            statement.execute(CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

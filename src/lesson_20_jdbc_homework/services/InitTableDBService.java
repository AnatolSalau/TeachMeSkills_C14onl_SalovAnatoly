package lesson_20_jdbc_homework.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitTableDBService {
    private Connection connection;
    //text of statement
    public static final String CREATE = "create table if not exists cars (" +
            "id int primary key, number varchar,jpg bytea, pdf bytea, dateCreation DATE " +
            ")";

    public InitTableDBService(Connection connection) {
        this.connection = connection;
    }

    public void init() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(CREATE);
    }
}

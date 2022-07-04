package lesson_20_jdbc_homework.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCarDBService {
    private static final String DELETE = "delete from cars where id = ";
    private static final String DELETE_ALL = "delete from cars";
    private Connection connection;

    public DeleteCarDBService(Connection connection) {
        this.connection = connection;
    }

    public void deleteById(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(DELETE + id);
    }

    public void deleteAllCars() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(DELETE_ALL);
    }
}

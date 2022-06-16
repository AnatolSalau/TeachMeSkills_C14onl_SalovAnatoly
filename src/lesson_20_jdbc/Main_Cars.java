package lesson_20_jdbc;

import lesson_20_jdbc.services.InitService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_Cars {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/lesson20_jdbc";
        String user = "postgres";
        String password = "sA#259979148307";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
            InitService service = new InitService(connection);
            service.init();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

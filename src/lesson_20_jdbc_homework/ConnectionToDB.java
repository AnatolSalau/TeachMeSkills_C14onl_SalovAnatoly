package lesson_20_jdbc_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionToDB {
    //Data DB to connect
    private String url;
    private String user;
    private String password;
    private Connection connection = null;

    //default connection
    public ConnectionToDB() {
        this.url = "jdbc:postgresql://localhost:5432/lesson_20_jdbc_homework";
        this.user = "postgres";
        this.password = "sA#259979148307";
    }
    //custom connection
    public ConnectionToDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public boolean startConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        if (connection != null) {
            return true;
        } else return false;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }
}

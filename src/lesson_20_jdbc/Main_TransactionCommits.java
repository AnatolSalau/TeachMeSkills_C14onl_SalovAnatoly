package lesson_20_jdbc;

import lesson_20_jdbc.entity.Brand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_TransactionCommits {
    public static final String UPDATE = "update cars set number = ?, brand = ?, age = ? where id = ?";
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/lesson20_jdbc";
        String user = "postgres";
        String password = "sA#259979148307";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, user, password);/*
        По умолчанию в JDBC любая операция коммитится (Подтверждается)
        connection.setAutoCommit - по умолчанию true;

        Можно оборачивать при помощи connection.setAutoCommit(false)
                                     connection.commit();
        Отменить изменения           connection.rollback();
     */
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(4,10);
            preparedStatement.setString(1,"number");
            preparedStatement.setString(2, Brand.AUDI.name());
            preparedStatement.setInt(3,32);
            preparedStatement.execute();
            //Коммитим(утверждаем все изменения)
            connection.commit();
        } catch (SQLException e) {
            //Можно отменить изменения в последнем коммите .rollback()
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}

package lesson_20_jdbc_homework.services;

import lesson_20_jdbc_homework.entity.Car;
import lesson_20_jdbc_homework.entity.JpgPdfFile;

import java.sql.*;

public class GetCarFromDBService {
    private static final String GET = "select * from cars where id = ?";
    private Connection connection;

    public GetCarFromDBService(Connection connection) {
        this.connection = connection;
    }

    public Car getCarById(int id) throws SQLException {
        Car carResult = null;
        PreparedStatement preparedStatement = connection.prepareStatement(GET);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //Проверяем с помощью next получили что-то или нет
        if (resultSet.next()) {
            //Получаем колoнки
            Integer newId = resultSet.getInt("id");
            String number = resultSet.getString("number");
            JpgPdfFile jpg = new JpgPdfFile(resultSet.getBytes("jpg"));
            JpgPdfFile pdf = new JpgPdfFile(resultSet.getBytes("pdf"));
            //Format '1960-02-03'
            Date dateCreation = resultSet.getDate("datecreation");
            carResult = new Car(newId, number, jpg, pdf, dateCreation);
            return carResult;
        } else {
            return carResult;
        }
    }
}

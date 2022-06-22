package lesson_20_jdbc_homework.services;

import lesson_20_jdbc_homework.entity.Car;
import lesson_20_jdbc_homework.entity.JpgPdfFile;

import java.sql.*;

public class SaveCarDBService {
    //text of prepare statement
    private static final String SAVE ="insert into cars (id, number, jpg, pdf, datecreation) " +
            "values (?,?,?,?,?)";
    //получаем max id и добавляем единицу
    private static final String GET_ID = "select max(id) + 1 as id from cars";

    private Connection connection;

    public SaveCarDBService(Connection connection) {
        this.connection = connection;
    }

    public void save(Car car) throws SQLException {
        //Get fields from object
        Integer id = car.getId();
        String number = car.getNumber();
        JpgPdfFile jpg = car.getJpg();
        JpgPdfFile pdf = car.getPdf();
        Date dateCreation = car.getDateCreation();

        PreparedStatement preparedStatement = null;
        Statement statement = connection.createStatement();

        // GET_ID = "select max(id) + 1 as id from cars";
        ResultSet resultSet = statement.executeQuery(GET_ID);
        /* id по умолчанию равно 0*/
        int next_id = 0;
        /*проверяем есть ли id c помощью next, если нету то сохраняем с id 0*/
        if (resultSet.next()) {
            /* если id eсть - увеличиваем его на 1*/
            next_id = resultSet.getInt("id");
        }
        //Создаем prepare statement
        preparedStatement = connection.prepareStatement(SAVE);
        //задаем параметры
        preparedStatement.setInt(1, next_id);
        preparedStatement.setString(2, number);
        preparedStatement.setBytes(3, jpg.getBytesFile());
        preparedStatement.setBytes(4, pdf.getBytesFile());
        preparedStatement.setDate(5, dateCreation);
        //Запускаем prepare statement
        preparedStatement.execute();
    }
}

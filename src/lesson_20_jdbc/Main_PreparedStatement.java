package lesson_20_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Main_PreparedStatement {
    public static void main(String[] args) {
        //Скачиваем драйвер с MAVEN repository MVN
        String url = "jdbc:postgresql://localhost:5432/lesson20_jdbc";
        String user = "postgres";
        String password = "sA#259979148307";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Create connection
            connection = DriverManager.getConnection(url,user,password);
            //PreparedStatement - объект через который общаемся с базой данных
            //где значения это ?
            //PreparedStatement - более производительный чем обычный Statement
            preparedStatement = connection.prepareStatement("select * from users where id = ?");
            //.setInt(number(index) of parametr, value)
            preparedStatement.setInt(1, 4);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();
            //перебираем циклом while
            while (resultSet.next()) {
                //int id = select.getInt(1);
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String passwordUser = resultSet.getString("password");
                users.add(new User(id,login,passwordUser));
            }
            users.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        System.out.println(preparedStatement);
    }

}

package lesson_20_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Main_StatementMethods {
    public static void main(String[] args) {
    //Скачиваем драйвер с MAVEN repository MVN
        String url = "jdbc:postgresql://localhost:5432/lesson20_jdbc";
        String user = "postgres";
        String password = "sA#259979148307";
        Connection connection = null;
        Statement statement = null;
        try {
            //Create connection
            connection = DriverManager.getConnection(url,user,password);
            //Statement - объект через который общаемся с базой данных
            statement = connection.createStatement();
            //Передаем запрос в базу данных скрипт на создание таблицы гыукы
/*            statement.execute("create table users (\n" +
                    "    id int primary key ,\n" +
                    "    login varchar,\n" +
                    "    password varchar\n" +
                    ")");*/
            //.execute() - используется для запросов без возврата результата (insert, delete)
//            boolean insert = statement.execute("insert into users (id,login,password) values (1,'first','fromjdbc')");
//            boolean update = statement.execute("update users set login ='update jdbc' where id = 4");
//            statement.execute("delete from users where id = 4");
            //выполняем select с помощью .executeQuery
            ResultSet select =statement.executeQuery("select * from users");
            List<User> users = new ArrayList<>();
            //перебираем циклом while
            while (select.next()) {
                //int id = select.getInt(1);
                int id = select.getInt("id");
                String login = select.getString("login");
                String passwordUser = select.getString("password");
                users.add(new User(id,login,passwordUser));
            }
            users.forEach(System.out::println);
            //.executeUpdate() - возвращает количество полей которые были обновлены
            //                   применяется для update and delete
            int countUpdate = statement.executeUpdate("update users set login ='updated' where id > 0");
            System.out.println(countUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        System.out.println(statement);
    }
}

package lesson_20_jdbc_homework;

import lesson_20_jdbc_homework.entity.Car;
import lesson_20_jdbc_homework.entity.JpgPdfFile;
import lesson_20_jdbc_homework.exceptions.MyRuntimeException;
import lesson_20_jdbc_homework.services.DeleteCarDBService;
import lesson_20_jdbc_homework.services.GetCarFromDBService;
import lesson_20_jdbc_homework.services.InitTableDBService;
import lesson_20_jdbc_homework.services.SaveCarDBService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //objects of images
        JpgPdfFile greenMercedesJpg = new JpgPdfFile("greenMercedes.jpg");
        JpgPdfFile redAudiJpg = new JpgPdfFile("redAudi.jpg");
        JpgPdfFile greenMercedesPdf = new JpgPdfFile("greenMercedes.pdf");
        JpgPdfFile redAudiPdf = new JpgPdfFile("redAudi.pdf");

        //Objects of cars (от года надо отнимать 1990)
        Car redAudi = new Car("001audi",redAudiJpg, redAudiPdf, new Date(1990-1990,0,1));
        Car greenMercedes = new Car(
                "001mercedes",greenMercedesJpg, greenMercedesPdf, new Date(2000-1900,11,12)
        );

        //Create connection
        ConnectionToDB connectionObject_1 = new ConnectionToDB();
        try {
            //Create connection
            if (connectionObject_1.startConnection()) {
                Connection connection_1 = connectionObject_1.getConnection();
                System.out.println("Connection is "+ !connection_1.isClosed() +" (" + connection_1 + ")");
                //Create table in DB
                InitTableDBService initTableDB = new InitTableDBService(connection_1);
                initTableDB.init();
                //Delete all cars
                DeleteCarDBService deleteCarDBService = new DeleteCarDBService(connection_1);
                deleteCarDBService.deleteAllCars();
                //Add Car to table
                SaveCarDBService saveCarDBService = new SaveCarDBService(connection_1);
                saveCarDBService.save(redAudi);
                saveCarDBService.save(greenMercedes);
                //Get Car from table
                GetCarFromDBService getCarFromDBService = new GetCarFromDBService(connection_1);
                Car carFromDB_0 = getCarFromDBService.getCarById(0);
                Car carFromDB_1 = getCarFromDBService.getCarById(1);
                //Check
                System.out.println(carFromDB_0);
                System.out.println(carFromDB_1);
                //Save jpg to file
                carFromDB_0.getJpg().saveImageToDirectory("carFromDb_0.jpg");
                carFromDB_1.getJpg().saveImageToDirectory("carFromDb_1.jpg");
                //Save pdf to file
                carFromDB_0.getPdf().saveImageToDirectory("carFromDb_0.pdf");
                carFromDB_1.getPdf().saveImageToDirectory("carFromDb_1.pdf");
                //Delete Car from table by id
                deleteCarDBService.deleteById(0);
                deleteCarDBService.deleteById(1);

                connection_1.close();
                System.out.println("Connection is " + !connectionObject_1.isClosed());
            } else {
                MyRuntimeException myRuntimeException =  new MyRuntimeException("Connection didn't start");
                System.out.println(myRuntimeException.getMessage());
                throw myRuntimeException;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

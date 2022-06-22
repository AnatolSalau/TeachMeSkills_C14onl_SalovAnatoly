package lesson_20_jdbc_homework.entity;

import java.sql.Date;

public class Car {
    private Integer id;
    private String number;
    private JpgPdfFile jpg;
    private JpgPdfFile pdf;
    //Format '1960-02-03'
    private Date dateCreation;

    public Car(Integer id, String number, JpgPdfFile jpg, JpgPdfFile pdf, Date dateCreation) {
        this.id = id;
        this.number = number;
        this.jpg = jpg;
        this.pdf = pdf;
        this.dateCreation = dateCreation;
    }

    public Car(String number, JpgPdfFile jpg, JpgPdfFile pdf, Date dateCreation) {
        //id create serviceCar
        this.id = null;
        this.number = number;
        this.jpg = jpg;
        this.pdf = pdf;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public JpgPdfFile getJpg() {
        return jpg;
    }

    public JpgPdfFile getPdf() {
        return pdf;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", jpg=" + jpg +
                ", pdf=" + pdf +
                ", dateCreation=" + dateCreation +
                '}';
    }
}

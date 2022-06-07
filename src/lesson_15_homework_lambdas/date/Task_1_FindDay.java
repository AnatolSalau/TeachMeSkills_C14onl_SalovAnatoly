package lesson_15_homework_lambdas.date;

import java.time.LocalDate;
import java.util.Scanner;

/*1. Написать программу для вывода на консоль названия дня недели по
        введенной дате.*/
public class Task_1_FindDay {
    public static void main(String[] args) {
        GetDateFromUser getDateFromUser = new GetDateFromUser();
        System.out.println("enter the date in the format: 01 02 1990");
        LocalDate localDate = getDateFromUser.getDateFromConsole();
        System.out.println("This day is " + localDate.getDayOfWeek());
    }
}

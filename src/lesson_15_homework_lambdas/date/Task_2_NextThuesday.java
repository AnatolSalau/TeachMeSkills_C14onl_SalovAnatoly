package lesson_15_homework_lambdas.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*1. 2. Написать программу для вывода на экран дату следующего вторника.*/
public class Task_2_NextThuesday {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        switch (dayOfWeek.name()) {
            case "MONDAY": {
                System.out.println("This day is MONDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(1).getDayOfMonth());
                break;
            }
            case "TUESDAY": {
                System.out.println("This day is TUESDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(7).getDayOfMonth());
                break;
            }
            case "WEDNESDAY": {
                System.out.println("This day is WEDNESDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(6).getDayOfMonth());
                break;
            }
            case "THURSDAY": {
                System.out.println("This day is THURSDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(5).getDayOfMonth());
                break;
            }
            case "FRIDAY": {
                System.out.println("This day is FRIDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(4).getDayOfMonth());
                break;
            }
            case "SATURDAY": {
                System.out.println("This day is SATURDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(3).getDayOfMonth());
                break;
            }
            case "SUNDAY": {
                System.out.println("This day is SUNDAY");
                System.out.println("Next tuesday is: " + localDate.plusDays(2).getDayOfMonth());
                break;
            }
        }
    }
}

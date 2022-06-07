package lesson_15_homework_lambdas.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/*1. 2. Написать программу для вывода на экран дату следующего вторника.*/
/*Переделал всю программу согласно замечанию*/
public class Task_2_NextThuesday {
    public static void main(String[] args) {
        //Используем TemporalAdjusters - что бы получить дату следуюущего вторника
        LocalDate nextTuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(nextTuesday);
        //Отформатируем дату
        String formattedDate = nextTuesday.format(DateTimeFormatter.ofPattern(("dd")));
        System.out.println("Date next tuesday: " + formattedDate );
    }
}

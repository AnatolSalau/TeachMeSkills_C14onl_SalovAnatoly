package lesson_15_classwork_lambdas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

class DateLesson {
    public static void main(String[] args) {
        //Отсчитывает время с 1970г
        long c = System.currentTimeMillis();
        Date dateCurrent = new Date(c);
        System.out.println(dateCurrent);
        //Получить объект даты с нужным временем
        LocalDate date = LocalDate.of(1990, 12, 1);
        System.out.println(date);
        //Получить объект времени с текущем временем
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //Получить и дату и время
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //Изменим локализацию jvm
//        Создадим русскую локализацию
        Locale locale = new Locale("ru","RU");
        //Форматирование даты с помощью SimpleDateFormat
        //Создадим паттерн
        String pattern = "EEE, d MMMM yyyy HH:mm:ss Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,locale);
        String dateAfterFormat = simpleDateFormat.format(dateCurrent);
        System.out.println(dateAfterFormat);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.plusDays(1).getDayOfWeek());
    }
}

package lesson_15_homework_lambdas.date;

import java.time.LocalDate;
import java.util.Scanner;

class GetDateFromUser {
    public LocalDate getDateFromConsole() {
        LocalDate result = null;
        try {
            String str = getStringFromUser();
            if (str != null) {
                String[] strings = str.split(" ");
                int year = Integer.parseInt(strings[2]);
                int month = Integer.parseInt(strings[1]);
                int day = Integer.parseInt(strings[0]);
                result = LocalDate.of(year, month, day);
            } else {
                System.out.println("String is null");
            }
        } catch (RuntimeException ex) {
            System.out.println("Scanner throw RuntimeException");
        }
        return result;
    }

    private String getStringFromUser() {
        String string = null;
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                string = scanner.nextLine();
            } else {
                System.out.println("Has next false");
            }
        } catch (RuntimeException ex) {
            throw ex;
        }
        return string;
    }
}

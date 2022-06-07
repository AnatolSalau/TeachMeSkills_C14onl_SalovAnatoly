package lesson_15_homework_lambdas.lambda;

import java.util.Scanner;

class ConsoleUserService {
    private Scanner scanner;

    public ConsoleUserService() {
        this.scanner = new Scanner(System.in);
    }

    public Integer getIntFromUser() {
        Integer number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        return number;
    }

    public String getStringFromUser() {
        String str = null;
        if (scanner.hasNextLine()) {
            scanner.nextLine();
            str = scanner.nextLine();
        }
        return str;
    }

    public void finish() {
        scanner.close();
    }
}

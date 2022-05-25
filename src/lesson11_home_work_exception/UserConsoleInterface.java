package lesson11_home_work_exception;

import java.util.Scanner;

public class UserConsoleInterface {
    private SimpleQueueString simpleQueueString;
    private Scanner scanner;

    public UserConsoleInterface(int maxLengthQueue) {
        this.simpleQueueString = new SimpleQueueString(maxLengthQueue);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Print exit for exit");
        System.out.println("Print get for getting last item from queue");
        System.out.println("Everything else will be added to the queue");
        while (true) {
            String string = getStringFromUser();
            switch (string) {
                case "exit": {
                    System.out.println("The program is closed");
                    return;
                }
                case "get": {
                    //Обрабатываем ошибку получения из очереди
                    try {
                        System.out.println(simpleQueueString.get());
                        break;
                    } catch (QueueExceptionIsEmpty ex) {
                        System.out.println(ex.getExceptionQueueIsEmpty());
                        ex.printStackTrace();
                    }
                }
                default: {
                    //Обрабатываем ошибку добавления элемента в очередь
                    try {
                        simpleQueueString.add(string);
                    } catch (QueueExceptionIsFull ex) {
                        System.out.println(ex.getExceptionQueueIsFull());
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private String getStringFromUser() {
        String string = scanner.next();
        return string;
    }

    public void closeScanner() {
        scanner.close();
    }
}

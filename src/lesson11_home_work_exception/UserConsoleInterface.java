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
        while(true) {
            String string = getStringFromUser();
            switch (string) {
                case "exit" :{
                    System.out.println("The program is closed");
                    return;
                }
                case "get": {
                    System.out.println(simpleQueueString.get());
                    break;
                }
                default: {
                    simpleQueueString.add(string);
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

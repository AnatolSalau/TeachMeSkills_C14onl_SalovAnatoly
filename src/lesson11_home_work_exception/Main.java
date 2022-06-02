package lesson11_home_work_exception;

public class Main {
    public static void main(String[] args) {
        UserConsoleInterface userConsoleInterface = new UserConsoleInterface(5);
        userConsoleInterface.start();
        userConsoleInterface.closeScanner();
    }
}

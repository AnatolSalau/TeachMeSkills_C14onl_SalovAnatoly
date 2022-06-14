package lesson_18_multitreading;

public class MyThreadImplements implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from MyThreadImplements");
    }
}

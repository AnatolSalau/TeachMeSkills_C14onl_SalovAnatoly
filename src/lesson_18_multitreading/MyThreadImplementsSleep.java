package lesson_18_multitreading;

public class MyThreadImplementsSleep implements Runnable {
    @Override
    public void run() {
        int sleep = 2_000;
        try {
            //Задержка 2000 мсек
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from MyThreadImplements sleep:" +  sleep);
    }
}

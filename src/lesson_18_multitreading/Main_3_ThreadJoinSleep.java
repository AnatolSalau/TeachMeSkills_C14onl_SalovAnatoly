package lesson_18_multitreading;

public class Main_3_ThreadJoinSleep {
    public static void main(String[] args) {
        MyThreadExtend myThreadExtend = new MyThreadExtend();
        MyThreadImplements myThreadImplements = new MyThreadImplements();
        MyThreadImplementsSleep myThreadImplementsSleep = new MyThreadImplementsSleep();
        System.out.println("Main Point Start");
        //Start myThreadExtend with .sleep
        Thread impSleepThread = new Thread(myThreadImplementsSleep);
        impSleepThread.start();
        System.out.println("impSleepThread.isAlive(): " + impSleepThread.isAlive());
        //Start thread myThreadExtend
        myThreadExtend.start();
        //Start thread myThreadImplements
        Thread impThread = new Thread(myThreadImplements);
        impThread.start();
        //.join - главный поток будет ждать пока не завершаться
        //потоки которые были вызванны
        try {
            impSleepThread.join();
            myThreadExtend.join();
            impThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("impSleepThread.isAlive(): " + impSleepThread.isAlive());
        System.out.println("myThreadExtend.isAlive(): " + myThreadExtend.isAlive());
        System.out.println("impThread.isAlive(): " + impThread.isAlive());
        System.out.println("Main Point End");
    }
}

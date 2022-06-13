package lesson_18_multitreading;

class MyThreadExtend extends Thread {
    //volatile - метка указывающая что переменную нужно всегда проверять
    // без volatile - java может положить переменную в кэш процессора
    private volatile boolean isRun = true;
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {
            System.out.println("Hello from my ThreadExtend");
            //Выход из бесконечного потока
            if (!isRun) {
                System.out.println("Break");
                break;
            }
        }
        System.out.println("After cycle");
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}

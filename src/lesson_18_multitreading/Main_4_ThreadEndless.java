package lesson_18_multitreading;

public class Main_4_ThreadEndless {
    public static void main(String[] args) {
        System.out.println("Main Point Start");
        //Бесконечный поток iplements Runnable
/*        MyThreadImplementsEndless myThreadImplementsEndless = new MyThreadImplementsEndless();
        Thread threadInpl = new Thread(myThreadImplementsEndless);
        threadInpl.start();*/
        //Нельзя изменить переменную isRun на false!!! (поток iplements Runnable)

        //Бесконечный поток extends Thread
        MyThreadExtend myThreadExtend = new MyThreadExtend();
        myThreadExtend.start();
        //Можно изменить переменную isRun на false - останавливая поток
        myThreadExtend.setRun(false);
        System.out.println("Main Point End");
    }
}

package lesson_18_multitreading;

public class Main_1_StartThread {
    public static void main(String[] args) {
        MyThreadExtend myThreadExtend = new MyThreadExtend();
        MyThreadImplements myThreadImplements = new MyThreadImplements();
        System.out.println("Main Point 1");
        //Start thread myThreadExtend
        myThreadExtend.start();
        //Start thread myThreadImplements
        Thread impThread = new Thread(myThreadImplements);
        impThread.start();
        System.out.println("Main Point 2");
/*        Main Point 1
        Main Point 2
        Hello from MyThreadImplements
        Hello from my ThreadExtend*/

    }
}

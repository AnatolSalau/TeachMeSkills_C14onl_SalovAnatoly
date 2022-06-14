package lesson_18_multitreading;

public class Main_2_ThreadMethods {
    public static void main(String[] args) {
        MyThreadExtend threadExtend_1 = new MyThreadExtend();
        MyThreadImplements myThreadImplements = new MyThreadImplements();
        System.out.println("Main Point Start");
        //Start thread threadExtend
        threadExtend_1.start();
        //Start thread myThreadImplements
        Thread threadImp_1 = new Thread(myThreadImplements);
        threadImp_1.start();
        //.sleep - останавливает потом на количество милисекунд

        System.out.println("Main Point End");
    }
}

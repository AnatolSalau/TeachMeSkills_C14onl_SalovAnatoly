package lesson_17_classwork_reflecsion;

import java.io.IOException;

public class WorkWithRuntime {
    public static void main(String[] args) {
        //Get current runtime (where is running current java program)
        Runtime runtime = Runtime.getRuntime();
        // .exec - выполняет  не в java программе а в операционной системе
        try {
            //compile .class
            Process process = runtime.exec("javac /Users/anatolysalov/JAVA/MyClass.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

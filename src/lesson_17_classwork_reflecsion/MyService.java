package lesson_17_classwork_reflecsion;

import jdk.jfr.Description;


@SuppressWarnings("SuppressWarning")
public class MyService {
    private String name;

    @Deprecated
    private String sname;

    @Description("print method")
    private void print() {
        System.out.println("private");
    }

    @Deprecated()
    public void printP() {
        System.out.println("public");
    }
}

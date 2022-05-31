package lesson_15_classwork_lambdas;

import java.util.Locale;

class LambdaLesson2 {
    public static void main(String[] args) {
        MathService mathService = new MathService();
        //Пишем реализацию прямо в параметрах метода
        System.out.println(mathService.process(4, 5, (v1, v2) -> v1 + v2));
        //void functionInterface
        StringService stringService = new StringService();
        stringService.process("Text", text -> System.out.println(text.trim().toUpperCase()));
    }


}

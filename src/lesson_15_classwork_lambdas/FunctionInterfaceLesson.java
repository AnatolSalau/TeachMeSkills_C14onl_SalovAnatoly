package lesson_15_classwork_lambdas;

import java.util.Locale;

class FunctionInterfaceLesson {
    public static void main(String[] args) {
        //Создадим функциональный интерфейс
        MyFunctionalInterface myFunctionalInterfaceOne = new MyFunctionalInterface() {
            @Override
            public void process(String text) {
                System.out.println(text);
            }
        };
        //Создадим еще один функциональный интерфейс
        MyFunctionalInterface myFunctionalInterfaceTwo = new MyFunctionalInterface() {
            @Override
            public void process(String text) {
                System.out.println(text.toUpperCase(Locale.ROOT));
            }
        };
        myFunctionalInterfaceOne.process("Hello");
        myFunctionalInterfaceTwo.process("Hello");
        //Создадим реализацию интерфейса с помощью лямбда функции
        MyFunctionalInterface myFunctionalInterfaceLambda = (String input) -> {
            System.out.println(input.toUpperCase(Locale.ROOT));
        };
        myFunctionalInterfaceLambda.process("Anatoly");
        //Если есть только одно действие -> можно убрать ковычки
        MyFunctionalInterface myFunctionalInterfaceLambda_2 = input ->
            System.out.println(input.toUpperCase(Locale.ROOT));
        myFunctionalInterfaceLambda_2.process("Vika");
    }
}

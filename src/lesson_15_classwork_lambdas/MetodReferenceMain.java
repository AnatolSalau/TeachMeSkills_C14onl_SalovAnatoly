package lesson_15_classwork_lambdas;

public class MetodReferenceMain {
    public static void main(String[] args) {
        MathServiceDouble mathServiceDouble = new MathServiceDouble();
        //Kлассическая лямбда - возводим в степень два числа
        double result1 = mathServiceDouble.process(
                5,5,(d1,d2) -> Math.pow(d1,d2)
        );
        System.out.println(result1);
        //Возведение в степень через metod reference
        //Если тело лямбды - это отдна строчка
        //Параметры передаются в той же самой последовательности
        double result2 = mathServiceDouble.process(
                5,5,Math::pow
        );
        PrintInterface printInterface = str -> System.out.println(str);
        printInterface.doPrint("Hello");
        //Укороченная реализация через Metod Reference
        PrintInterface printInterface1 = System.out::println;
        //Вызов конструктора через metod reference с помощью new
        User user = new User("Anatoly", 32, 256987);
        UserToAccountConverter accountConverter = new UserToAccountConverter();
        //Классическая лямбда
        Account account0 = accountConverter.convert(user,us -> new Account(us));
        System.out.println(account0);
        //MetodReference
        Account account1 = accountConverter.convert(user,Account::new);
        System.out.println(account1);
    }
}

package lesson_15_homework_lambdas.lambda;

/*3. Создать обобщенный функциональный интерфейс.
        Написать класс с одним методом.
        В этом методе реализуйте логику:
        - если в консоль введена цифра 1, то: использования интерфейса со
        строковым типом и передать в метод интерфейса логику реверса
        строки(вывода строки в обратном порядке).
        - если в консоль введена цифра 2, то: использования интерфейса с
        целочисленным типом и передать в метод интерфейса логику
        нахождения факториала числа.*/
public class Main {
    public static void main(String[] args) {
        ConsoleUserService consoleUserService = new ConsoleUserService();
        ChangeStringInteger changeStringInteger = new ChangeStringInteger();
        System.out.println("Enter 1(String) or 2(Integer)");
        Integer number = consoleUserService.getIntFromUser();
        switch (number) {
            case 1: {
                System.out.println("Enter string");
                String strFromUser = consoleUserService.getStringFromUser();
                //Реализация через лямбду, саму лямбду вынесем в отдельный метод
                String result = changeStringInteger.changeString(strFromUser, Main::reverseString);
                System.out.println(result);
                break;
            }
            case 2: {
                System.out.println("Enter integer");
                Integer intFromUser = consoleUserService.getIntFromUser();
                //Реализация через лямбду, саму лямбду вынесем в отдельный метод
                Integer result = changeStringInteger.changeInteger(intFromUser,Main::factorialInt);
                System.out.println(result);
                break;
            }
            default: {
            }
        }
        consoleUserService.finish();
    }
    private static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }
    private static Integer factorialInt (Integer integer) {
        int num = 1;
        for (int i = 1; i <= integer; i++) {
            num = num * i;
        }
        return num;
    }
}

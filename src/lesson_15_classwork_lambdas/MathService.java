package lesson_15_classwork_lambdas;

class MathService {
    //Используем функциональный интерфейс в методе класса
    //Реализацию этого интерфейса мы не знаем
    public int process (int value1, int value2, MathInterface math) {
        return math.doSmth(value1,value2);
    }
}

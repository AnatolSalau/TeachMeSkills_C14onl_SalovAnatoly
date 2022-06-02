package lesson_15_classwork_lambdas;

class MathServiceDouble {
    //Используем функциональный интерфейс в методе класса
    //Реализацию этого интерфейса мы не знаем
    public double process (double value1, double value2, MathInterfaceDouble math) {
        return math.doSmth(value1,value2);
    }
}

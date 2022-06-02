package lesson_15_classwork_lambdas;

@FunctionalInterface
interface MyFunctionalInterface {
    //Один не реализованный метод
    void process(String text);
    //Дефолтных методов может быть несколько
    default String print() {
        if (validdate()) {
            return "True";
        }
        else return "false";
    }
    //Несколько статических методов
    static Integer getCount() {
        return 5;
    }
    //Приватные методы можно использовать в дефолтных методах
    private Boolean validdate() {
        return true;
    }
}

package lesson_15_homework_lambdas.lambda;

@FunctionalInterface
public interface Changer<T> {
    T change(T somethingObject);
}

package lesson_15_homework_lambdas.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ClassLambdaMethod<S> {
        public S lambdaMethod (S stringOrInteger, UnaryOperator<S> changer) {
        return  changer.apply(stringOrInteger);
    }
}

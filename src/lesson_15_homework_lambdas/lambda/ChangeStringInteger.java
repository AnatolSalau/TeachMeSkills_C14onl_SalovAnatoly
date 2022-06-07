package lesson_15_homework_lambdas.lambda;

import java.util.function.UnaryOperator;

public class ChangeStringInteger {
        public String changeString(String string, ChangeString changer) {
        return  changer.change(string);
        }
        public Integer changeInteger(Integer integer, ChangeInteger changer) {
            return  changer.change(integer);
        }
}

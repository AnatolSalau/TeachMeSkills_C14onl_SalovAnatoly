package lesson_16_homework;

class CollectionService {
    public enum EvenOrOdd {
        EVEN, ODD
    }
    public Integer getIntegerWithConditions(Integer number, int startValue, int finishValue, EvenOrOdd evenOrOdd) {
        Integer result = null;
        switch (evenOrOdd) {
            case EVEN -> {
                if (checkEvenOrNot(number) && number >= startValue && number <= finishValue) {
                    result = number;
                }
            }
            case ODD -> {
                if (!checkEvenOrNot(number) && number >= startValue && number <= finishValue) {
                    result = number;
                }
            }
        }
        return result;
    }
    private boolean checkEvenOrNot (Integer integer) {
        if (integer % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

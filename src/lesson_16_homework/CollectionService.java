package lesson_16_homework;

import java.util.List;

class CollectionService {
    public boolean getIntegerWithConditions(Integer number, int startValue, int finishValue) {
        boolean result = false;
                if (checkEvenOrNot(number) && number >= startValue && number <= finishValue) {
                    result = true;
                }
        return result;
    }
    public boolean checkEvenOrNot (Integer integer) {
        if (integer % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int getAverage (List<Integer> integerList) {
        int result = 0;
        for (Integer num : integerList) {
            result +=num;
        }
        return result/integerList.size();
    }
}

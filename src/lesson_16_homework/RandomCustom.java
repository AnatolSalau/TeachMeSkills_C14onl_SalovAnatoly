package lesson_16_homework;

import java.util.ArrayList;

class RandomCustom {
    public ArrayList<Integer> getRandomListInteger(int capacity) {
        ArrayList<Integer> result = new ArrayList<>(capacity);
        for (Integer integer : result) {
            integer = getRandomInteger();
        }
        return  result;
    }
    private Integer getRandomInteger() {
        Integer result;
        RandomCustom random = new RandomCustom();
        result = random.getRandomInteger();
        return result;
    }
}

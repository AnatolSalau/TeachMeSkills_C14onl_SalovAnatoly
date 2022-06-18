package lesson_16_homework;

import java.util.ArrayList;
import java.util.Random;

class RandomCustom {
    public ArrayList<Integer> getRandomListInteger(int capacity, int startRandomValue, int finishRandomValue) {
        ArrayList<Integer> result = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            result.add(i, getRandomInteger(startRandomValue,finishRandomValue));
        }
        return  result;
    }
    private Integer getRandomInteger(int startRandomValue, int finishRandomValue) {
        Integer result;
        Random random = new Random();
        result = random.nextInt(startRandomValue,finishRandomValue);
        return result;
    }
}

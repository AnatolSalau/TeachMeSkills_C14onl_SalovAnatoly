package lesson_16_homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomCustom random = new RandomCustom();
        List<Integer> integerList = random.getRandomListInteger(50);
        System.out.println(integerList);
    }
}

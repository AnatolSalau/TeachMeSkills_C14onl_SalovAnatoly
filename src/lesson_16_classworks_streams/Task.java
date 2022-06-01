package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
        //Найти сумму всех факториалов четных чисел, через stream
        int[] array = new int[] {0,1,2,3,4,5,6,7,8};
        IntStream stream = Arrays.stream(array);
        List<Integer> list = (List<Integer>) stream
                .sorted()
                .collect(Collectors.);
    }
}

package lesson_16_classworks_streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Task {
    public static void main(String[] args) {
        //Найти сумму всех факториалов четных чисел, через stream
        int[] array = new int[] {0,1,2,3,4};
        IntStream intStream = Arrays.stream(array);
        OptionalInt summFactorial = intStream
                .filter(num ->num >0 && num%2 == 0)
                .map(num -> factorial(num))
                .reduce((num1,num2) -> num1 + num2);
        int summFactorialInt = summFactorial.getAsInt();
        System.out.println(summFactorialInt);
    }
    private static int factorial(int number) {
        int result = 1;
        if (number == 0) return 0;
        for (int i = 1; i <= number; i++) {
            result = result*i;
        }
        return result;
    }
}

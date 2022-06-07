package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Stream_06 {
    public static class Statistic {
        int value = 0;
    }
    public static void main(String[] args) {
        //Stream with int
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int maxInt = IntStream.of(array)
                .max().getAsInt();
        System.out.println(maxInt);
        //IntSummaryStatistics
        IntSummaryStatistics summaryStatistics = Arrays.stream(array)
                .summaryStatistics();
        System.out.println(summaryStatistics);
        System.out.println(summaryStatistics.getSum());
        //Variable in stream have to be final!
        final Statistic statistic = new Statistic();
        System.out.println(statistic.value);
        //We can change final objects in stream
        Arrays.stream(array)
                .forEach( number -> statistic.value = statistic.value +1);
        System.out.println(statistic.value);

    }
}

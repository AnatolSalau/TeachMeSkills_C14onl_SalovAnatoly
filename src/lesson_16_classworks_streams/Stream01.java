package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("first", "second", "last", "fir", "fi");
        //#1 Stream Instance
/*        //Create Stream 1 way
        list.stream();

        //Create Stream 2 way
        int[] array = new int[] {0,1,2,3,4,5,6,7};
        Arrays.stream(array);

        //Create Stream 3 way
        Stream.of("first", "second", "last");
        Stream.of(1,2,3,4,5,6);*/

        //#2 Intermediate Operations
        //конвейерные методы (промежуточные)

        //.filter - get Predicate from FunctionalInterface
        //фильтруем на основе predicate откидывая не прошедшие проверку
        Stream<String> myStream = list.stream().filter((element) -> element.length() >= 5);
        //Stream is lazy
        //Need to start stream
        List<Integer> collect1 =
                list.stream()
                        //max size of stream
                        .limit(4)
                        //.distinct - отбросить повторяющиеся элементы
                        .distinct()
                        //сортируем с помощью Comaprable или Comparator
/*                        .sorted((el1,el2) -> {return el1.length() > el2.length() ? -1;})*/
                        .peek(System.out::println)
                        .filter((element) -> element.startsWith("f"))
                        .filter((element) -> element.length() >= 3)
                        // .peek - get Concumer
/*                        .peek(element -> System.out.println(element))*/
                        //Metod reference
                        .peek(System.out::println)
                        //.map - get Function
                        .map(text -> text.length())
                        //Metod reference
/*                        .map(String::length)*/
                        //Integer stream
                        //Terminate - запустить stream
                        .collect(Collectors.toList());
        System.out.println(collect1);
        // .peek - get Concumer
        //Стрим берет каждый элемент проводит его до конца проводя с ним все опрерации

    }
}

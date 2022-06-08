package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Stream00 {

    public static void main(String[] args) {
        int length = 3;
        String startWith = "D";
        String[] strings = {"Aaaaaa", "Bbbbb", "Cccc","Ddd","Ddd","Dd","D","Ee"};
        //Create stram iterations
        Stream<String> stream01 = Arrays.stream(strings);
        //Сортируем .filter по длине, predicate вынесем в отдельный метод
        Stream<String> stream01_1 = stream01.filter(el ->stringLength(el,length));
        //Print in console with .peek
        Stream<String> stream01_2 = stream01_1.peek(el -> System.out.println("lengthFilter " + el));
        //Сортируем .filter по начинается ли с чегото
        Stream<String> stream01_3 = stream01_2.filter(el -> stringStartWith(el,startWith));
        //Print in console with .peek
        Stream<String> stream01_4 = stream01_3.peek(System.out::println);
        //Change elements with .map ()
        Stream<String> stream01_5 = stream01_4.map(el -> el.toUpperCase());
        //Create  Stream<Integer> with lengths
        Stream<Integer> stream01_6 = stream01_5.map(String::length);
        //Get only 3 elements with .limit
        Stream<Integer> stream01_7 = stream01_6.limit(3);
        //remove equals elements
        Stream<Integer> stream01_8 = stream01_7.distinct();
        //Create terminate operations, to create List
        List<Integer> resultList01 = stream01_8.collect(Collectors.toList());
        System.out.println(resultList01);

        //also, you can create streams through dot with method reference
        List<String> Stream01_3 = Arrays.stream(strings)
                .filter(Stream00::stringLengthEqual3)
                .filter(Stream00::stringStartWithE)
                //Print in console with .peek
                .peek(System.out::println)
                //Change element with .map
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(Stream01_3);
        //
        String[] namesArray = {"Ccccccc", "Bbbb", "Aa"};
        Stream<String> streamNames = Arrays.stream(namesArray);
        List<String> stringNames;
        stringNames = streamNames
                //Sort streams by .sort
                .sorted()
                .peek(System.out::print)
                //Sort by comparator
                .sorted((el1, el2) -> {
                        return el2.length() > el1.length() ? 1 : -1;
                    }
                )
                .peek(System.out::print)
                //Sort by comparator in separate method
                .sorted((el1,el2) -> customComparator(el1,el2))
                //Sort by comparator method reference
                .sorted(Stream00::customComparator)
                //Sort by comparator method reference 2
                .sorted(Comparator.comparing(String::length))
                .peek(System.out::print)
                .collect(Collectors.toList());
        System.out.println(stringNames);

    }
    public static int customComparator(String el1, String el2) {
        return el2.length() > el1.length() ? -1 : 1;
    }
    private static boolean stringLength(String el, int length) {
        return el.length() <= length;
    }
    private static boolean stringLengthEqual3(String el) {
        return el.length() <= 3;
    }
    private static boolean stringStartWith(String el, String startWith) {
        return el.startsWith(startWith);
    }
    private static boolean stringStartWithE(String el) {
        return el.startsWith("E");
    }

}

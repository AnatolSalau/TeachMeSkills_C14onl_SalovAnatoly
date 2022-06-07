package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForkJoinPool {
    public static void main(String[] args) {
        List<Family> familyList = Arrays.asList(
                new Family("firstFamily", 3, Arrays.asList(
                        new Member("member1",30, Member.SEX.MAN,true),
                        new Member("member1",30, Member.SEX.MAN,true),
                        new Member("member1",30, Member.SEX.MAN,true)
                )), new Family("secondFamily", 4, Arrays.asList(
                        new Member("member1",30, Member.SEX.MAN,true),
                        new Member("member1",30, Member.SEX.MAN,true),
                        new Member("member1",30, Member.SEX.MAN,true)
                ))

        );
        //Multithreadings streams
        long count =  familyList.parallelStream()
                .flatMap(family -> family.getMembers().stream())
                .count();
        System.out.println(count);
        //ForkJoinPool


    }
}

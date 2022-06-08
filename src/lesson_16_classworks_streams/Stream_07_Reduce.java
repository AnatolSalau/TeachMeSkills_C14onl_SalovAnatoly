package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Stream_07_Reduce {
    public static void main(String[] args) {
        List<Family> familyList = Arrays.asList(
                new Family("Family-01", 3, Arrays.asList(
                        new Member("member1-1",31, Member.SEX.MAN,true),
                        new Member("member1-2",32, Member.SEX.WOMAN,false),
                        new Member("member1-3",33, Member.SEX.MAN,true),
                        new Member("member3-3",34, Member.SEX.WOMAN,false),
                        new Member("member3-3",35, Member.SEX.WOMAN,false)
                )), new Family("Family-02", 4, Arrays.asList(
                        new Member("member2-1",41, Member.SEX.MAN,true),
                        new Member("member2-2",42, Member.SEX.MAN,true),
                        new Member("member2-3",43, Member.SEX.WOMAN,false),
                        new Member("member2-3",44, Member.SEX.WOMAN,false)
                )), new Family("Family-03", 5, Arrays.asList(
                        new Member("member3-1",51, Member.SEX.WOMAN,false),
                        new Member("member3-2",52, Member.SEX.MAN,true),
                        new Member("member3-3",53, Member.SEX.WOMAN,false)
                ))
        );
        //Summ ages all members
        //Stream all members
        Stream<Member> allMembersStream = familyList.stream()
                .flatMap(family -> family.getMembers().stream());
        //Stream all ages
        Stream<Integer> agesStream = allMembersStream.map(Member::getAge);
        //Reduce - summ all
        Optional<Integer> summOptional = agesStream.reduce((age1, age2) -> age1 + age2);
        System.out.println(summOptional.get());

        //factorial 5 = 150
        Stream<Integer> numberStream = Stream.of(2, 3, 4, 5);
        int identity = 1;
        int factorialInt = numberStream.reduce(identity, (x,y)->x * y);
        System.out.println(factorialInt);  // 120

        //Summ all int plus identity = 1
        Stream<Integer> numberStream2 = Stream.of(2, 3, 4, 5);
        int summInt = numberStream2.reduce(identity, (x,y)->x + y);
        System.out.println(summInt);  // 15
    }
}

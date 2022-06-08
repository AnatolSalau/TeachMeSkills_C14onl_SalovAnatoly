package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Stream05_TerminalOperations {
    public static void main(String[] args) {
        List<Family> familyList = Arrays.asList(
                new Family("Family-01", 3, Arrays.asList(
                        new Member("member1-1",31, Member.SEX.MAN,true),
                        new Member("member1-2",32, Member.SEX.WOMAN,false),
                        new Member("member1-3",33, Member.SEX.MAN,true),
                        new Member("member1-4",34, Member.SEX.WOMAN,false),
                        new Member("member1-5",35, Member.SEX.WOMAN,false)
                )), new Family("Family-02", 4, Arrays.asList(
                        new Member("member2-1",41, Member.SEX.MAN,true),
                        new Member("member2-2",42, Member.SEX.MAN,true),
                        new Member("member2-3",43, Member.SEX.WOMAN,false),
                        new Member("member2-4",44, Member.SEX.WOMAN,false)
                )), new Family("Family-03", 5, Arrays.asList(
                        new Member("member3-1",51, Member.SEX.WOMAN,false),
                        new Member("member3-2",52, Member.SEX.MAN,true),
                        new Member("member3-3",53, Member.SEX.WOMAN,false)
                ))
        );
        //Terminal operations
        //1. .collect(Collectors.toLists())
        //2. forEach(); adopt Conscumer (тоже самое что .peek)
        Stream<Family> familyStream01 = familyList.stream();
        //print in console all members c помощью forEach
        familyStream01
        .flatMap(family -> family.getMembers().stream())
        .forEach(member -> System.out.println(member));
        //.findMin
        Stream<Family> familyStream02 = familyList.stream();
        Optional<Member> memberMinAge = familyStream02
                .flatMap(family -> family.getMembers().stream())
                .min((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        System.out.println(memberMinAge.get());
        //.anyMath (Predicate) check - is there anyone who matches the condition
        Boolean haveMemberAge53 = familyList.stream()
                .flatMap(family -> family.getMembers().stream())
                .anyMatch(member -> member.getAge() == 53);
        System.out.println(haveMemberAge53); //true
    }
}

package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream03 {
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

        Stream<Family> familyStream = familyList.stream();
        //Get list all family's names from family's list
        List<String> nameList = familyStream.map(family -> family.getSname()).collect(Collectors.toList());
        System.out.println(nameList);
        //Get list all family's with age ==5
        List<String> familyListAge = familyList.stream()
                .filter(family -> family.getAge() == 5)
                .map(family -> family.getSname())
                .collect(Collectors.toList());
        System.out.println(familyListAge);
        //Get stream with all lists of members from all families
        List<Member> allMembers = familyList.stream()
                .flatMap(family -> family.getMembers().stream())
                //
                .collect(Collectors.toList());
        System.out.println(allMembers);
        //Get set with names all members they have age more than 51
        Set<String> allNamesMembersAgeMore50 = familyList.stream()
                        .flatMap(family -> family.getMembers().stream())
                        .filter(member -> member.getAge() > 51)
                        .map(member -> member.getName())
                        .collect(Collectors.toSet());
        System.out.println(allNamesMembersAgeMore50);
    }
}

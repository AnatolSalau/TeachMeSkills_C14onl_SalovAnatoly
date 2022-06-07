package lesson_16_classworks_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream04 {
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
        //Create map Name - Age
        Map<String, Integer> mapNameAge = familyList.stream()
                .flatMap(family -> family.getMembers().stream())
                .collect(Collectors.toMap(member -> member.getName(), member -> member.getAge()));
        System.out.println(mapNameAge);
    }
}

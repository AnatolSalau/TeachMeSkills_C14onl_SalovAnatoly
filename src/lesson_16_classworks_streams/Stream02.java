package lesson_16_classworks_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Stream02 {
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
        familyList.stream()
                //фильтр по возрасту
                .filter(fam -> fam.getAge()>4)
                .map(family -> family.getMembers())
                //.flatMap() Function interface
                //Возвращает stream  с мемберов
/*                .map(family -> family.getSname())*/
                .collect(Collectors.toList());
        Map<String,Integer> collect =
        familyList.stream()
                //фильтр по возрасту
                .filter(fam -> fam.getAge()>4)
                //.flatMap() Function interface
                //Возвращает stream  с мемберов (каких то других объектов)
                .flatMap(family -> family.getMembers().stream())
                //map возвращает какой то объект
/*                .map(family -> family.getSname())*/
                //Преобразовать к листу
/*                .collect(Collectors.toList());*/
                //Преобразовать к сету
/*                .collect(Collectors.toSet());*/
            //Преобразовать к Map
                .collect(Collectors.toMap(member -> member.getName(),
                                member -> member.getAge()
                                ));
        System.out.println(collect);
    }
}

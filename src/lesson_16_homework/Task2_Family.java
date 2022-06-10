package lesson_16_homework;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*Создать класс Family со следующими полями
        фамилия (уникально в рамках задания)
        адресс
        средняя зарплата на члена семьи
        список детей (ребёнок имеет имя, возраст, пол)
        С помощью Stream'ов:
        - Сгенерировать map где ключ - фамилия семьи, а значение - размер зп
        - Вывести количество мальчиков (в разрезе всех семей)
        - Вывести всех девочек
        - Вывести информацию сколько у какой семью детей
        - вывести есть ли хоть одна семья у которой есть ребенок с именем ...*/
class Task2_Family {
    public static void main(String[] args) {
        //Дети
        Child child1 = new Child("Child1", 15, Child.SEX.MAN);
        Child child2 = new Child("Child2", 16, Child.SEX.WOMAN);
        Child child3 = new Child("Child3", 17, Child.SEX.MAN);
        Child child4 = new Child("Child4", 18, Child.SEX.WOMAN);
        Child child5 = new Child("Child5", 19, Child.SEX.MAN);
        Child child6 = new Child("Child6", 20, Child.SEX.WOMAN);
        Child child7 = new Child("Child7", 21, Child.SEX.MAN);
        Child child8 = new Child("Child8", 22, Child.SEX.WOMAN);
        Child child9 = new Child("Child9", 23, Child.SEX.MAN);
        Child child10 = new Child("Child10", 24, Child.SEX.WOMAN);
        //Cемьи
        Family family1 = new Family(
                "Family1", "Family1 adress", 1000,
                Arrays.asList(child1, child2)
        );
        Family family2 = new Family(
                "Family2", "Family2 adress", 1150,
                Arrays.asList(child3, child4, child5)
        );
        Family family3 = new Family(
                "Family3", "Family3 adress", 1400,
                Arrays.asList(child6, child7, child8, child9, child10)
        );
        //Массив семей
        Family[] families = {family1, family2, family3};
        //- Сгенерировать map где ключ - фамилия семьи, а значение - размер зп
        Map<String, Double> mapSurnameAverageSalary = Arrays.stream(families)
                .collect(Collectors.toMap(Family::getSurName, Family::getAverageSalary));
        System.out.println(mapSurnameAverageSalary);
        //- Вывести количество мальчиков (в разрезе всех семей)
        long countAllMan = Arrays.asList(families).stream()
                //Все дети
                .flatMap(family -> family.getChildren().stream())
                //Только мальчики
                .filter(child -> child.getSex() == Child.SEX.MAN)
                .count();
        System.out.println(countAllMan);
        //- Вывести всех девочек
        Arrays.asList(families).stream()
                //Все дети
                .flatMap(family -> family.getChildren().stream())
                //Только девочки
                .filter(child -> child.getSex() == Child.SEX.WOMAN)
                //выводим в консоль
                .forEach(System.out::print);
        System.out.println();
        //Вывести информацию сколько у какой семью детей
        Map<String, Integer> mapFamilyNameQuantityChildren = Arrays.asList(families).stream()
                .collect(Collectors.toMap(Family::getSurName, family -> family.getChildren().size()));
        System.out.println(mapFamilyNameQuantityChildren);
        //вывести есть ли хоть одна семья у которой есть ребенок с именем ...*/
        String name = "Child1";
        boolean haveChildrenWithName = Arrays.asList(families).stream()
                //Берем всех детей
                .flatMap(family -> family.getChildren().stream())
                //Проверяем на имя
                .anyMatch(child -> child.getName().equals(name));
        System.out.println(haveChildrenWithName);
    }
}

package lesson_16_homework;
/*1) Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
        С помощью Stream'ов:
        - Удалить дубликаты
        - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
        - Каждый элемент умножить на 2
        - Отсортировать и вывести на экран первых 4 элемента
        - Вывести количество элементов в стриме
        - Вывести среднее арифметическое всех чисел в стриме*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1_ArrayList {
    public static void main(String[] args) {
        RandomCustom random = new RandomCustom();
        List<Integer> integerList = random.getRandomListInteger(50, 0, 20);
        System.out.println(integerList);

        //Создаем экземпляр класса для проверки и задаем условия
        CollectionService collectionService = new CollectionService();
        int startValue = 7;
        int finishValue = 17;

        //Удаляем дубликаты
        List<Integer> listWithoutDuplicates = integerList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("listWithoutDuplicates:" + listWithoutDuplicates);

        //Выводим все четные элементы от 7 до 17, делаем по очереди
        integerList.stream()
                //оставляем четные
                .filter(number -> collectionService.checkEvenOrNot(number))
                //оставляем от 7 до 17
                .filter(number -> collectionService.getIntegerWithConditions(number, startValue, finishValue))
                //Выводим
                .forEach(System.out::print);

        //Умножаем каждый элемент на 2
        int[] multipleOn2 = integerList.stream()
                .map(number -> number = number * 2)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("multiple on 2" + Arrays.toString(multipleOn2));
        System.out.printf("\n");

        //Отсортировать и вывести на экран первых 4 элемента
        integerList.stream()
                .sorted(Integer::compareTo)
                .limit(4)
                .forEach(System.out::print);
        System.out.printf("\n");

        //Вывести количество элементов в стриме
        long integerSize = integerList.stream().count();
        System.out.println(integerSize);

        //Вывести среднее арифметическое всех чисел в стриме
        int result = integerList.stream()
                .collect(Collectors.collectingAndThen(
                        //Получаем среднее арифметичсеское в формате Integer
                        Collectors.averagingInt(Integer::intValue),
                        //приводим Integer к int
                        averagingSalary -> averagingSalary.intValue()
                ));
        System.out.println(result);
        //Проверим с помощью метода
        System.out.println(collectionService.getAverage(integerList));
    }
}

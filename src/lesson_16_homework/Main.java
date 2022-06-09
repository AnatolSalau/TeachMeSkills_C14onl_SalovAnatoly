package lesson_16_homework;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        RandomCustom random = new RandomCustom();
        List<Integer> integerList = random.getRandomListInteger(50,0,20);
        System.out.println(integerList);
        //Создаем экземпляр класса для проверки и задаем условия
        CollectionService collectionService = new CollectionService();
        int startValue = 7;
        int finishValue = 17;
        CollectionService.EvenOrOdd even = CollectionService.EvenOrOdd.EVEN;

        //Удаляем дубликаты
        List<Integer> listWithoutDuplicates = integerList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("listWithoutDuplicates:" + listWithoutDuplicates);
                //Выводим все четные элементы от 7 до 17
        integerList.stream().forEach(number -> {
            System.out.print(
                    collectionService.getIntegerWithConditions(
                            number,startValue,finishValue,
                            even)
            );
        });


/*                //Умножаем каждый элемент на 2
                .map(number -> number = number*2)
                //Сортируем
                .sorted(Integer::compareTo)
                //Берем только первых 4 элемента
                .limit(4)
                //Выводим на экран
                .peek(System.out::print)
                .*/

    }

}

package lesson14_homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Task2_QuantityMaxNumber_Map {
    public static void main(String[] args) {
        //число  4 встречается 5 раз
        int[] numbers = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 3, 4, 0, 4,-1,-2};
        // создаем словарь где будут лежать количество число и количество. Заменил HashMap на Map
        Map<Integer, Integer> analysis = new HashMap<>();
        //бежим по массиву и записываем числа в словарь
        for ( int number: numbers ) {
            //Проверяем есть ли такое число в словаре или нету, если нету добавляем 1
            if (analysis.containsKey(number)) {
                // добавляем к имеющимуся количеству повторений +1
                Integer value = analysis.get(number);
                value +=1;
                analysis.put(number,value);
            }
            else {
                //добавляем число с количетсвом повторений 1
                analysis.put(number,1);
            }
        }
        System.out.println(analysis);
    }
}

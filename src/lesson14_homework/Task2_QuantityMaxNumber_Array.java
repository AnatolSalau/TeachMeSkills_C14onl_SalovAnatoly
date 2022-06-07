package lesson14_homework;

import java.util.Arrays;

//Решение через массив - только с неотрицательными числами
class Task2_QuantityMaxNumber_Array {
    public static void main(String[] args) {
        //число  4 встречается 5 раз
        int[] numbers = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 3, 4, 0, 4};
        System.out.println(Arrays.toString(numbers));
        //Перебираем циклом определяя сколько раз какое число встречается
        //Результат записываем в другой массив
        //Само число - это индекс
        //Количество повторений это - значение в данном индексе
        //Соответственно, создаем массив длинной равной величине максимального числа в массиве плюс 1
        int[] analysis = new int[maxNumber(numbers) + 1];
        System.out.println(Arrays.toString(analysis));
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            analysis[number] += 1;
        }
        //Получили количество чисел каждого числа
        System.out.println(Arrays.toString(analysis));
        //Находим максимальные количество и индекс - который и будет нашим числом
        int number = 0;
        int maxQuantity = analysis[0];
        for (int i = 0; i < analysis.length; i++) {
            if (analysis[i] > maxQuantity) {
                maxQuantity = analysis[i];
                number = i;
            }
        }
        System.out.printf("Max number: %d\n", number);
        System.out.printf("Quantity: %d\n", maxQuantity);
    }

    private static int maxNumber(int[] numbers) {
        //любая реализация нахождения максимального числа
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
}

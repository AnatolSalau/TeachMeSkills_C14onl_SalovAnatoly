package lesson14_homework;

import java.util.Comparator;

public class ComparatorName implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
            //Берем код ASCII первых букв
            //Код первой буквы первого обьекта
            int codeCurrent = user1.getName().charAt(0);
            //Код первой буквы второго обьекта
            int codeExternal = user2.getName().charAt(0);
            //возвращаем результат вычитания
            return codeCurrent - codeExternal;
    }
}

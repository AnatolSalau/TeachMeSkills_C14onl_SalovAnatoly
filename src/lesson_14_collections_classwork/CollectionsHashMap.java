package lesson_14_collections_classwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsHashMap {
    public static void main(String[] args) {
     //HashMap автоматически сортирует объекты в зависимости от возвращаемого значения hashCode
     //HashMap ищет только дубликаты по ключу!
        HashMap<String,UserCumtomHash> usersHash = new HashMap();
        usersHash.put("first",new UserCumtomHash(30,"C_Third"));
        usersHash.put("first",new UserCumtomHash(25,"C_Third"));
        usersHash.put("second",new UserCumtomHash(30,"A_Third_First"));
        usersHash.put("third",new UserCumtomHash(25,"B_Second"));
        //Получаем item по ключу
        System.out.println(usersHash.getOrDefault(
                "four", new UserCumtomHash(0, "Default")));
    }
}

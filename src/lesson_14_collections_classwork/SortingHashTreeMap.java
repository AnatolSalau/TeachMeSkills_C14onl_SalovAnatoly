package lesson_14_collections_classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class SortingHashTreeMap {
    public static void main(String[] args) {
        HashMap<String,UserCumtomHash> usersHash = new HashMap();
        usersHash.put("ddddd",new UserCumtomHash(30,"C_Third"));
        usersHash.put("ccccc",new UserCumtomHash(25,"C_Third"));
        usersHash.put("bbbbb",new UserCumtomHash(30,"A_Third_First"));
        usersHash.put("aaaaa",new UserCumtomHash(25,"B_Second"));
/*        Используйте реализацию TreeMap, в данном случае Java сама будет отсортировывать данные по ключу.
                Map<String, Object> treeMap = new TreeMap<String, Object>(yourHashMap);
         Сортировка будет проходить согласно методу compareTo класса, которым является ключ*/
        Map<String,UserCumtomHash> userCumtomHashMap = new TreeMap<>(usersHash);
        System.out.println(userCumtomHashMap);
        //Сортируем TreeMap используя компаратор
        Map<User,String> usersMap = new TreeMap<>(new UserComparatorAge());
        usersMap.put(new User(35,"C_Third"),"first");
        usersMap.put(new User(30,"C_Third"),"second");
        usersMap.put(new User(25,"A_Third_First"),"third");
        usersMap.put(new User(20,"B_Second"),"fourth");
        System.out.println(usersMap);
        Set<User> keys = usersMap.keySet();
        for (User key : keys ) {
            System.out.println(key.toString());
        }
    }
}


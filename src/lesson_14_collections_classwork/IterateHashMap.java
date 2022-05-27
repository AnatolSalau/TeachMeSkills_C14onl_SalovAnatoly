package lesson_14_collections_classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class IterateHashMap {
    public static void main(String[] args) {
        HashMap<String,UserCumtomHash> usersHash = new HashMap();
        usersHash.put("ddddd",new UserCumtomHash(30,"C_Third"));
        usersHash.put("ccccc",new UserCumtomHash(25,"C_Third"));
        usersHash.put("bbbbb",new UserCumtomHash(30,"A_Third_First"));
        usersHash.put("aaaaa",new UserCumtomHash(25,"B_Second"));
        //Представляем Map как сет используя метод entrySet
        Set<Map.Entry<String, UserCumtomHash>> entries = usersHash.entrySet();
        //Перебираем с помощью foreach
        for (Map.Entry<String, UserCumtomHash> map : entries) {
            System.out.println("key: " + map.getKey());
            System.out.println("Value: " + map.getValue());
        }
        //Перебираем по ключам используя метод .keySet()
        Set<String> keys = usersHash.keySet();
        for (String key : keys ) {
            System.out.println(usersHash.get(key));
        }
    }
}

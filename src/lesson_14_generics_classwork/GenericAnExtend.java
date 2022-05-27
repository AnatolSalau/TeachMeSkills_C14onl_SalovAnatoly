package lesson_14_generics_classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericAnExtend {
    public static void main(String[] args) {
        DBServiceExtend<Cl2,Cl4> serviceExtend = new DBServiceExtendImp<>();
        serviceExtend.save(new Cl3());
        //Коллекции с непонятным типом
        //В лист можно добавить любого наследника Cl3 паттерн PECS
        List<? super Cl3> list = new ArrayList<>();
        list.add(new Cl3());
        list.add(new Cl4());
        //Перебрать можем только через Object
        for (Object obj : list) {
            System.out.println(obj);
        }
        //Можно обойти данный паттерн используя метод .asList
        List<? extends Cl3> list2 = Arrays.asList(new Cl3(),new Cl4());
        //классический способ add не работает
/*        list2.add(new Cl3());*/
        //Можно обойти обычным foreach
        for (Cl3 element : list2 ) {
            System.out.println(element);
        }
    }
}

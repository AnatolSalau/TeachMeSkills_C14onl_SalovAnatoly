package lesson_14_collections_classwork;

import java.util.ArrayList;
import java.util.Collections;
//Сортировка строк в ArrayList
public class CollectionsSortString {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");
        Collections.sort(al);
        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + al);
        Collections.sort(al, Collections.reverseOrder());
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + al);
    }
}

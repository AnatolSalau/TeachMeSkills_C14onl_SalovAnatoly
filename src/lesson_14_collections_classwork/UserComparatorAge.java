package lesson_14_collections_classwork;

import java.util.Comparator;
//Comparator по полю типа Int
public class UserComparatorAge implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if(user1.getAge()> user2.getAge())
            return 1;
        else if(user1.getAge()< user2.getAge())
            return -1;
        else
            return 0;
    }
}

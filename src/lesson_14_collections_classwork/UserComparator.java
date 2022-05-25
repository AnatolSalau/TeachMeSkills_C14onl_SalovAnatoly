package lesson_14_collections_classwork;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
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

package lesson14_homework;

import java.util.Comparator;

public class ComparatorAge implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if (user2.getAge() == user1.getAge()) {
            return 0;
        } else if (user2.getAge() > user1.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
}

package lesson_14_collections_classwork;

import java.util.Comparator;
//Comparator по полю типа Стринг
class UserComparatorName implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
            return user1.getName().compareTo(user2.getName());
    }
}

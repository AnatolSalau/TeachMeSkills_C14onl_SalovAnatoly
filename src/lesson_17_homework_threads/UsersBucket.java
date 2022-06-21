package lesson_17_homework_threads;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class UsersBucket {
    private Map<String, User> bucket;

    public UsersBucket(Map<String, User> bucket) {
        this.bucket = bucket;
    }

    public UsersBucket() {
        bucket = new HashMap<>();
    }

    public void addUser(String key, User user) throws InterruptedException {
        System.out.println("addUser() start!");
        Thread.sleep(500);
        bucket.put(key, user);
        System.out.println("addUser() end!");
    }

    public Map<String, User> findUsersByName(String name) throws InterruptedException {
        System.out.println("findUsersByName() start!");
        Thread.sleep(500);
        Map<String, User> result = null;
        //Create set from map and then create stream
        result = bucket.entrySet().stream()
                .filter(user -> userNameIsEqualAnotherName(user.getValue(), name))
                .collect(Collectors.toMap(user -> user.getKey(), user -> user.getValue()));
        System.out.println("findUsersByName() end!");
        return result;
    }

    public void deleteUsersByName(String name) throws InterruptedException {
        System.out.println("deleteUsersByName() start!");
        Thread.sleep(500);
        this.bucket = bucket.entrySet().stream()
                //Create map without users which have this name
                .filter(user -> !userNameIsEqualAnotherName(user.getValue(), name))
                .collect(Collectors.toMap(user -> user.getKey(), user -> user.getValue()));
        System.out.println("deleteUsersByName() end!");
    }

    protected Map<String, User> getBucket() {
        return bucket;
    }

    private boolean userNameIsEqualAnotherName(User user, String name) {
        return user.getName().equals(name);
    }
}

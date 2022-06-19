package lesson_17_homework_threads;

import java.util.Map;

class UsersBucketSynchronized extends UsersBucket {
    public UsersBucketSynchronized(Map<String, User> bucket) {
        super(bucket);
    }

    public UsersBucketSynchronized() {
        super();
    }

    @Override
    public void addUser(String key, User user) throws InterruptedException {
        synchronized (super.getBucket()) {
            super.addUser(key, user);
        }
    }

    @Override
    public Map<String, User> findUsersByName(String name) throws InterruptedException {
        synchronized (super.getBucket()) {
            return super.findUsersByName(name);
        }
    }

    @Override
    public void deleteUsersByName(String name) throws InterruptedException{
        synchronized (super.getBucket()) {
            super.deleteUsersByName(name);
        }
    }

    @Override
    protected Map<String, User> getBucket() {
        synchronized (super.getBucket()) {
            return super.getBucket();
        }
    }
}

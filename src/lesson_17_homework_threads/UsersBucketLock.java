package lesson_17_homework_threads;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class UsersBucketLock extends UsersBucket {

    private Lock lock = new ReentrantLock();

    public UsersBucketLock(Map<String, User> bucket) {
        super(bucket);
    }

    public UsersBucketLock() {
        super();
    }

    @Override
    public void addUser(String key, User user) throws InterruptedException {
        lock.lock();
        super.addUser(key, user);
        lock.unlock();
    }

    @Override
    public Map<String, User> findUsersByName(String name) throws InterruptedException {
        lock.lock();
        Map<String, User> result = super.findUsersByName(name);
        lock.unlock();
        return result;
    }

    @Override
    public void deleteUsersByName(String name) throws InterruptedException {
        //Блокируем метод write  - чтобы никто не мог записать туда пока мы удаляем
        lock.lock();
        super.deleteUsersByName(name);
        lock.unlock();
    }

    @Override
    protected Map<String, User> getBucket() {
        //Блокируем запись
        lock.lock();
        Map<String, User> result = super.getBucket();
        lock.unlock();
        return result;
    }
}

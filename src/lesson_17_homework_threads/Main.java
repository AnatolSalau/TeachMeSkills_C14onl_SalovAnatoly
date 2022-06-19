package lesson_17_homework_threads;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //Create empty bucket
        UsersBucketSynchronized usersBucketSynchronized = new UsersBucketSynchronized();

        //Create Runnable objects
        AddUserThread addUserThread = new AddUserThread(usersBucketSynchronized,
                "addUserThread_1",
                new User("First", 10)
        );
        FindUserThread findUserThread = new FindUserThread(usersBucketSynchronized, "First");
        DeleteUserThread deleteUserThread = new DeleteUserThread(usersBucketSynchronized, "First");

        Thread addUserThread_1 = new Thread(addUserThread);
        Thread findUserThread_1 = new Thread(findUserThread);
        Thread deleteUserThread_1 = new Thread(deleteUserThread);
        //Start infinity thread 500ms step
        addUserThread_1.start();
        findUserThread_1.start();
        deleteUserThread_1.start();
        //Main thread sleep 3000ms
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addUserThread.stopRun();
        findUserThread.stopRun();
        deleteUserThread.stopRun();
        System.out.println(usersBucketSynchronized.getBucket());
    }
}

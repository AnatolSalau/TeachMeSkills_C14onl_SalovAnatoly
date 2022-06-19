package lesson_17_homework_threads;

public class AddUserThread implements Runnable {
    private UsersBucket usersBucket;
    private volatile boolean isRun = false;
    private User user;
    private String key;

    public AddUserThread(UsersBucket usersBucket, String key, User user) {
        this.usersBucket = usersBucket;
        this.user = user;
        this.key = key;
    }

    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                usersBucket.addUser(key, user);
            } catch (InterruptedException e) {
                System.out.println("Sleep Exception:");
                e.printStackTrace();
            }
        }
    }

    public void stopRun() {
        isRun = false;
    }
}

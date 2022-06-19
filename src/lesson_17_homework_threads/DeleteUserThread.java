package lesson_17_homework_threads;

public class DeleteUserThread implements Runnable {
    private UsersBucket usersBucket;
    private volatile boolean isRun = false;
    private String name;

    public DeleteUserThread(UsersBucket usersBucket, String name) {
        this.usersBucket = usersBucket;
        this.name = name;
    }

    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                usersBucket.deleteUsersByName(name);
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

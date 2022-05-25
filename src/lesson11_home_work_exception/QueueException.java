package lesson11_home_work_exception;

public class QueueException extends Exception {
    protected String item;
    protected int maxLengthQueue;

    public QueueException() {
    }

    public QueueException(String item, int maxLengthQueue) {
        this.item = item;
        this.maxLengthQueue = maxLengthQueue;
    }
}

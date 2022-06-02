package lesson11_home_work_exception;

public class QueueExceptionIsFull extends QueueException {
    public QueueExceptionIsFull(String item, int maxLengthQueue) {
        super(item, maxLengthQueue);
    }

    public String getExceptionQueueIsFull() {
        return "EXCEPTION: Queue is full, item(" + super.item
                + ") cant add in Queue. Max length queue: " +
                super.maxLengthQueue + " items.";
    }
}

package lesson11_home_work_exception;

public class QueueExceptionIsEmpty extends QueueException {
    public QueueExceptionIsEmpty() {
    }

    public String getExceptionQueueIsEmpty() {
        return "EXCEPTION: Queue is empty, can't get item";
    }
}

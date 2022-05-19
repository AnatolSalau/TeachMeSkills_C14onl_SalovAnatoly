package lesson11_home_work_exception;

public interface QueueString  {
//    Добавить элемент в конец очереди
    void add(String item) throws QueueExceptionIsFull;
//    Извлечение элемента из начала очереди
    String get() throws QueueExceptionIsEmpty;
//    Проверяем пустая ли очередь или нет
    boolean isEmpty();
}

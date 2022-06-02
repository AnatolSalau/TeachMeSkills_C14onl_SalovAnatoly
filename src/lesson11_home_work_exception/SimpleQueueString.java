package lesson11_home_work_exception;

import java.util.Arrays;

public class SimpleQueueString implements QueueString {
    private String[] queue;
    private int lastIndex;

    public SimpleQueueString(int maxLengthQueue) {
        queue = new String[maxLengthQueue];
        lastIndex = queue.length - 1;
    }

    public void printQueue() {
        System.out.println(Arrays.toString(queue));
    }

    @Override
    public void add(String item) throws QueueExceptionIsFull {
        //  Проверяем есть ли место в конце очереди
        if (queue[lastIndex] == null) {
            //  Бежим с начала очереди и записываем в первый свободный элемент
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] == null) {
                    queue[i] = item;
                    break;
                }
            }
        } else {
            //Кидаем ошибку в UserConsoleInterface
            throw new QueueExceptionIsFull(item, queue.length);
        }
    }

    @Override
    public String get() throws QueueExceptionIsEmpty {
        String result = queue[0];
        //Проверяем пуста ли очередь
        if (!isEmpty()) {
            //Сдвигаем все эелементы на один к началу
            for (int i = 0; i < queue.length - 1; i++) {
                queue[i] = queue[i + 1];
            }
            //всегда меняем последний индекс на null, чтобы не осталось старого значения
            queue[lastIndex] = null;
            return result;
        }
        //Если пуста кидаем  ошибку в UserConsoleInterface
        else {
            throw new QueueExceptionIsEmpty();
        }
    }

    @Override
    public boolean isEmpty() {
        if (queue[0] == null) {
            return true;
        } else return false;
    }
}

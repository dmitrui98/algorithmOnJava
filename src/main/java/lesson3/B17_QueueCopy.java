package lesson3;

import common.data.structure.queue.LinkedListQueue;
import common.data.structure.util.base.QueueInterface;
import util.ArrayUtil;

/**
 * Упражнение 1.3.41
 */
public class B17_QueueCopy {
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        QueueInterface<Integer> queueCopy = new LinkedListQueue<>(queue);
        ArrayUtil.print(queue);
        ArrayUtil.print(queueCopy);
    }
}

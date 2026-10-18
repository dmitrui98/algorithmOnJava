package common.data.structure.queue;

import common.data.structure.util.base.QueueInterface;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Упражнение 1.3.39
 * Кольцевой буфер (очередь) фиксированного размера
 */
public class RingArrayQueue<T> implements QueueInterface<T> {
    private T[] array;
    private volatile int readIndex;
    private volatile int writeIndex;

    public RingArrayQueue(int size) {
        array = (T[]) new Object[size];
    }

    public boolean isFull() {
        return writeIndex == array.length;
    }

    @Override
    public boolean isEmpty() {
        return readIndex == array.length;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void enqueue(T item) {
        array[writeIndex++] = item;
        if (writeIndex == array.length) {
            readIndex = 0;
        }
    }

    @Override
    public T dequeue() {
        T item = array[readIndex++];
        if (readIndex == array.length) {
            writeIndex = 0;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

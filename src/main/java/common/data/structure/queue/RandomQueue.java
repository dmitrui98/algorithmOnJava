package common.data.structure.queue;

import common.data.structure.util.base.RandomQueueInterface;
import common.data.structure.util.iterator.RandomIterator;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomQueue<T> implements RandomQueueInterface<T> {
    private T[] a = (T[]) new Object[1];
    private int n;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void enqueue(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;
    }

    @Override
    public T dequeue() {
        int j = StdRandom.uniformInt(n);
        T temp = a[j];
        a[j] = a[--n];
        a[n] = null;
        if (n > 0 && a.length == n / 4) {
            resize(a.length / 2);
        }
        return temp;
    }

    @Override
    public T sample() {
        return a[StdRandom.uniformInt(n)];
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomIterator<>(a, n);
    }

    private void resize(int newSize) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[newSize];
        System.arraycopy(a, 0, array, 0, n);
        a = array;
    }
}

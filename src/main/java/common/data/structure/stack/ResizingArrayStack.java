package common.data.structure.stack;

import common.data.structure.util.base.StackInterface;
import java.util.Iterator;

/**
 * Листинг 1.3.5. Алгоритм 1.1
 */
public class ResizingArrayStack<T> implements StackInterface<T> {
    private T[] a = (T[]) new Object[1];
    private int n;

    public ResizingArrayStack() {
    }

    public ResizingArrayStack(int capacity) {
        a = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void push(T item) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    @Override
    public T pop() {
        T item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public T peek() {
        return a[n - 1];
    }

    public int currentCapacity() {
        return a.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, n);
        a = temp;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }
}

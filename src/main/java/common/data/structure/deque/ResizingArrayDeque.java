package common.data.structure.deque;

import common.data.structure.util.base.Deque;
import java.util.Iterator;

public class ResizingArrayDeque<T> implements Deque<T> {
    private T[] a = (T[]) new Object[10];
    private int n;
    private int firstIndex;
    private int lastIndex;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    public int arraySize() {
        return a.length;
    }

    @Override
    public void pushLeft(T element) {
        if (n == a.length) {
            resize(n * 2);
        }
        if (isEmpty()) {
            a[lastIndex++] = element;
        } else if (firstIndex == 0) {
            T[] newArray = (T[]) new Object[a.length];
            newArray[0] = element;
            for (int i = 0; i < lastIndex; i++) {
                newArray[i + 1] = a[i];
            }
            lastIndex++;
            a = newArray;
        } else {
            a[--firstIndex] = element;
        }
        n++;
    }

    @Override
    public void pushRight(T element) {
        if (n == a.length) {
            resize(n * 2);
        }
        a[lastIndex++] = element;
        n++;
    }

    @Override
    public T popLeft() {
        T item = a[firstIndex];
        a[firstIndex] = null;
        firstIndex++;
        n--;
        if (isEmpty()) {
            firstIndex = 0;
            lastIndex = 0;
        }
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public T popRight() {
        T item = a[--lastIndex];
        a[lastIndex] = null;
        n--;
        if (isEmpty()) {
            firstIndex = 0;
            lastIndex = 0;
        }
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public T removeAt(int index) {
        if (index >= n) {
            return null;
        }
        T item = a[index];
        for (int i = index; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = null;
        lastIndex--;
        n--;
        if (isEmpty()) {
            firstIndex = 0;
        }
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInner();
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = firstIndex; i < lastIndex; i++) {
            newArray[i - firstIndex] = a[i];
        }
        a = newArray;
        lastIndex = lastIndex - firstIndex;
        firstIndex = 0;
    }

    private class IteratorInner implements Iterator<T> {
        int first = firstIndex;
        int last = lastIndex;

        @Override
        public boolean hasNext() {
            return first < last;
        }

        @Override
        public T next() {
            return a[first++];
        }
    }
}

package common.data.structure.queue;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings implements Queue<String> {
    String[] a;
    int firstIndex = 0;
    int lastIndex = 0;
    int n = 0;

    public ResizingArrayQueueOfStrings() {
        a = new String[1];
    }

    public ResizingArrayQueueOfStrings(int capacity) {
        a = new String[capacity];
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
    public void enqueue(String item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        n++;
        a[lastIndex++] = item;
    }

    @Override
    public String dequeue() {
        String item = a[firstIndex];
        a[firstIndex] = null;
        firstIndex++;
        n--;
        if (isEmpty()) {
            lastIndex = 0;
            firstIndex = 0;
        }
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorInner();
    }

    private void resize(int newSize) {
        String[] temp = a;
        a = new String[newSize];
        for (int i = firstIndex; i < lastIndex; i++) {
            a[i - firstIndex] = temp[i];
        }
        lastIndex -= firstIndex;
        firstIndex = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = firstIndex; i < lastIndex; i++) {
            sb.append(a[i]).append(", ");
        }
        return sb.toString();
    }

    private class IteratorInner implements Iterator<String> {
        int first = firstIndex;
        int last = lastIndex;

        @Override
        public boolean hasNext() {
            return first < last;
        }

        @Override
        public String next() {
            return a[first++];
        }
    }
}

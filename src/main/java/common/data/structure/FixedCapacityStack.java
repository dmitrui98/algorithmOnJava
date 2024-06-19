package common.data.structure;

public class FixedCapacityStack<T> {
    private final T[] a;
    private int n;

    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        a[n++] = item;
    }

    public T pop() {
        return a[--n];
    }
}

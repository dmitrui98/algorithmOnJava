package common.data.structure.stack;

public class FixedCapacityStackOfStrings {
    private final String[] a;
    private int n;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }

    public boolean isFull() {
        return a.length == n;
    }
}

package common.data.structure.util;

public class Node<T> {
    public T item;
    public Node<T> next;

    public Node() {
    }

    public Node(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        String n = next == null ? "null" : next.item.toString();
        return String.format("Node(item=%s), next: %s", item, n);
    }
}

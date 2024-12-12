package common.data.structure.util;

public class DoubleNode<T> extends Node<T> {
    public DoubleNode<T> prev;
    public DoubleNode<T> next;

    public DoubleNode() {
    }

    public DoubleNode(T item) {
        super(item);
    }

    @Override
    public String toString() {
        String n = next == null ? "null" : next.item.toString();
        String p = prev == null ? "null" : prev.item.toString();
        return String.format("Node(item=%s), prev: %s, next: %s", item, p, n);
    }
}

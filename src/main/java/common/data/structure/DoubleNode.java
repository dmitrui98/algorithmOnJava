package common.data.structure;

public class DoubleNode<T> {
    public T item;
    public DoubleNode<T> next;
    public DoubleNode<T> prev;

    public DoubleNode() {
    }

    public DoubleNode(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        String n = next == null ? "null" : next.item.toString();
        String p = prev == null ? "null" : prev.item.toString();
        return String.format("Node(item=%s), prev: %s, next: %s", item, p, n);
    }

//    @Override
//    public String toString() {
//        return item.toString();
//    }
}

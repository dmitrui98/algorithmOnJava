package common.data.structure.list;

public class CustomList<T> {
    private T item;
    private Node<T> next;

    private static class Node<T> {
        T item;
        Node<T> next;
    }
}

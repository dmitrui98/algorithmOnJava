package common.data.structure.list;

import common.data.structure.Node;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> first;

    public Node<T> addFirst(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        return first;
    }

    public Node<T> addLast(T item) {
        if (first == null) {
            return addFirst(item);
        }
        Node<T> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>();
        current.next.item = item;
        return current.next;
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        } else {
            T item = first.item;
            first = first.next;
            return item;
        }
    }

    public T removeLast() {
        if (first == null) {
            return null;
        }
        Node<T> current = first;
        Node<T> prev = first;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        if (prev == current) {
            // один элемент в списке
            return removeFirst();
        } else {
            prev.next = null;
            return current.item;
        }
    }

    public T removeAt(int k) {
        if (first == null) {
            return null;
        }
        if (k == 0) {
            return removeFirst();
        }
        Node<T> current = first;
        Node<T> prev = first;
        int i = 0;
        while (current != null && i <= k) {
            if (i == k) {
                prev.next = current.next;
                return current.item;
            }
            prev = current;
            current = current.next;
            i++;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInner();
    }

    private class IteratorInner implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}

package common.data.structure.list;

import common.data.structure.DoubleNode;

import java.util.Iterator;

public class CustomDoubleLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> first;
    private DoubleNode<T> last;

    public DoubleNode<T> getFirst() {
        return first;
    }

    public DoubleNode<T> getLast() {
        return last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public DoubleNode<T> addFirst(T item) {
        DoubleNode<T> addNode = new DoubleNode<>(item);
        addNode.prev = null;
        if (isEmpty()) {
            addNode.next = null;
            last = addNode;
        } else {
            addNode.next = first;
            first.prev = addNode;
        }
        first = addNode;
        return addNode;
    }

    public DoubleNode<T> addLast(T item) {
        DoubleNode<T> addNode = new DoubleNode<>(item);
        addNode.next = null;
        if (isEmpty()) {
            addNode.prev = null;
            first = addNode;
        } else {
            addNode.prev = last;
            last.next = addNode;
        }
        last = addNode;
        return addNode;
    }

    public DoubleNode<T> insertBefore(DoubleNode<T> node, T item) {
        if (node == first) {
            return addFirst(item);
        }
        DoubleNode<T> addNode = new DoubleNode<>(item);
        if (node.prev != null) {
            node.prev.next = addNode;
        }
        addNode.prev = node.prev;
        addNode.next = node;
        node.prev = addNode;
        return addNode;
    }

    public DoubleNode<T> insertAfter(DoubleNode<T> node, T item) {
        if (node == last) {
            return addLast(item);
        }
        DoubleNode<T> addNode = new DoubleNode<>(item);
        if (node.next != null) {
            node.next.prev = addNode;
        }
        addNode.next = node.next;
        addNode.prev = node;
        node.next = addNode;
        return addNode;
    }

    public DoubleNode<T> removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (last == first) {
            last = null;
            first = null;
            return null;
        }
        DoubleNode<T> removed = first;
        first = first.next;
        first.prev = null;
        return removed;
    }

    public DoubleNode<T> removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (last == first) {
            last = null;
            first = null;
            return null;
        }
        DoubleNode<T> removed = last;
        last = last.prev;
        last.next = null;
        return removed;
    }

    public boolean remove(DoubleNode<T> forRemove) {
        if (forRemove == null) {
            return false;
        }
        if (forRemove == last) {
            removeLast();
            return true;
        }
        if (forRemove == first) {
            removeFirst();
            return true;
        }
        DoubleNode<T> current = first;
        while (current != null) {
            if (current == forRemove) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInner();
    }

    private class IteratorInner implements Iterator<T> {
        private DoubleNode<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T forReturn = current.item;
            current = current.next;
            return forReturn;
        }
    }
}

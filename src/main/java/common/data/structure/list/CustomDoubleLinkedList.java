package common.data.structure.list;

import common.data.structure.util.DoubleNode;
import common.data.structure.util.base.Deque;
import common.data.structure.util.iterator.LinkedIterator;
import java.util.Iterator;

public class CustomDoubleLinkedList<T> implements Deque<T> {
    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int n;

    public DoubleNode<T> getFirst() {
        return first;
    }

    public DoubleNode<T> getLast() {
        return last;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void pushLeft(T element) {
        addFirst(element);
    }

    @Override
    public void pushRight(T element) {
        addLast(element);
    }

    @Override
    public T popLeft() {
        return removeFirst().item;
    }

    @Override
    public T popRight() {
        return removeLast().item;
    }

    @Override
    public T removeAt(int index) {
        if (index == 0) {
            return removeFirst().item;
        }
        if (index == n - 1) {
            return removeLast().item;
        }
        DoubleNode<T> current = first;
        int i = 0;
        while (current != null) {
            if (i == index) {
                current.prev.next = current.next;
                ((DoubleNode<T>) current.next).prev = current.prev;
                n--;
                return current.item;
            }
            current = (DoubleNode<T>) current.next;
            i++;
        }
        return null;
    }

    public DoubleNode<T> addFirst(T item) {
        DoubleNode<T> addNode = new DoubleNode<>(item);
        if (isEmpty()) {
            last = addNode;
        } else {
            addNode.next = first;
            first.prev = addNode;
        }
        first = addNode;
        n++;
        return addNode;
    }

    public DoubleNode<T> addLast(T item) {
        DoubleNode<T> addNode = new DoubleNode<>(item);
        if (isEmpty()) {
            first = addNode;
        } else {
            addNode.prev = last;
            last.next = addNode;
        }
        last = addNode;
        n++;
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
        n++;
        return addNode;
    }

    public DoubleNode<T> insertAfter(DoubleNode<T> node, T item) {
        if (node == last) {
            return addLast(item);
        }
        DoubleNode<T> addNode = new DoubleNode<>(item);
        if (node.next != null) {
            ((DoubleNode<T>) node.next).prev = addNode;
        }
        addNode.next = node.next;
        addNode.prev = node;
        node.next = addNode;
        n++;
        return addNode;
    }

    public DoubleNode<T> removeFirst() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode<T> removed = first;
        if (last == first) {
            last = null;
            first = null;
            return removed;
        }
        first = (DoubleNode<T>) first.next;
        first.prev = null;
        n--;
        return removed;
    }

    public DoubleNode<T> removeLast() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode<T> removed = last;
        if (last == first) {
            last = null;
            first = null;
            return removed;
        }
        last = (DoubleNode<T>) last.prev;
        last.next = null;
        n--;
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
                ((DoubleNode<T>) current.next).prev = current.prev;
                n--;
                return true;
            }
            current = (DoubleNode<T>) current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(first);
    }
}

package common.data.structure.list;

import common.data.structure.Node;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> first;

    public Node<T> getFirst() {
        return first;
    }

    /**
     * Return element by index
     * @return node element or null
     */
    public Node<T> get(int index) {
        int i = 0;
        Iterator<Node<T>> iterator = iteratorNode();
        while (iterator.hasNext()) {
            if (i == index) {
                return iterator.next();
            }
            i++;
        }
        return null;
    }

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

    public void insertAfter(Node<T> node, Node<T> forInsert) {
        if (node == null || forInsert == null) {
            return;
        }
        Node<T> temp = node.next;
        node.next = forInsert;
        forInsert.next = temp;
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

    public void removeAfter(Node<T> node) {
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    public int removeAll(T key) {
        if (first == null) {
            return 0;
        }
        Node<T> current = first;
        Node<T> prev = first;
        int countRemoved = 0;
        while (current != null) {
            if (current.item.equals(key)) {
                countRemoved++;
                if (current == prev) {
                    first = first.next;
                    prev = first;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return countRemoved;
    }

    /**
     * @return list item index or null
     */
    public Integer find(T item) {
        int i = 0;
        for (T e : this) {
            if (e.equals(item)) {
                return i;
            }
            i++;
        }
        return null;
    }

    public Integer max() {
        if (first == null || !(first.item instanceof Integer)) {
            return 0;
        }
        int max = (Integer) first.item;
        for (T item : this) {
            Integer intItem = (Integer) item;
            if (intItem > max) {
                max = intItem;
            }
        }
        return max;
    }

    public Integer maxRecursive(Node<Integer> first, Integer max) {
        if (first == null) {
            if (max == Integer.MIN_VALUE) {
                return 0;
            }
            return max;
        }
        if (first.item > max) {
            max = first.item;
        }
        return maxRecursive(first.next, max);
    }

    /**
     * Reverse list and return first node of result list
     * Exercise 1.3.30
     */
    public Node<T> reverseListCustom() {
        if (first == null) {
            return null;
        }
        Node<T> current = first;
        Node<T> c;
        Node<T> start = null;
        Node<T> swapped = null;
        while (current != swapped && current.next != null) {
            c = current;
            Node<T> prev = null;
            while (c.next != swapped) {
                if (prev != null) {
                    prev.next = c.next;
                } else {
                    start = c.next;
                }
                prev = c.next;
                swap(c, c.next);
            }
            swapped = c;
            current = start;
        }
        first = current;
        return first;
    }

    public Node<T> reverseList() {
        Node<T> start = first; // первый узел (остатка) первого списка
        Node<T> reverse = null; // первый узел результирующего обращенного списка
        while (start != null) {
            Node<T> next = start.next; // второй узел (остатка) первого списка
            start.next = reverse;
            reverse = start;
            start = next;
        }
        first = reverse;
        return first;
    }

    public Node<T> reverseListRecursive(Node<T> first) {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            return first;
        }
        Node<T> second = first.next;
        Node<T> rest = reverseListRecursive(second);
        second.next = first;
        first.next = null;
        this.first = rest;
        return rest;
    }

    private void swap(Node<T> first, Node<T> second) {
        first.next = second.next;
        second.next = first;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInner();
    }

    public Iterator<Node<T>> iteratorNode() {
        return new IteratorInnerNode();
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

    private class IteratorInnerNode implements Iterator<Node<T>> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<T> next() {
            Node<T> forReturn = current;
            current = current.next;
            return forReturn;
        }
    }
}

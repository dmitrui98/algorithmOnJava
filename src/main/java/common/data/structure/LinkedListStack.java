package common.data.structure;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Листинг 1.3.6. Алгоритм 1.2
 * Стэк. Реализация на основе связного списка
 */
public class LinkedListStack<T> implements Iterable<T> {
    /**
     * Верхушка стэка
     */
    private Node<T> first;

    /**
     * Количество элементов
     */
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public T peek() {
        return first.item;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<T> {
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

package common.data.structure;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Листинг 1.3.8. Алгоритм 1.3. Очередь
 */
public class LinkedListQueue<T> implements Iterable<T> {
    private Node<T> first; // самый старый узел
    private Node<T> last; // самый свежий узел
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    /**
     * Добавление элемента в конец списка
     */
    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * Удаление элемента из начала списка
     */
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new QueueIteratorInner();
    }

    private class QueueIteratorInner implements Iterator<T> {
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

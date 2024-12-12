package common.data.structure.queue;

import common.data.structure.util.Node;
import common.data.structure.util.base.QueueInterface;
import java.util.Iterator;

/**
 * Упражение 1.3.29. Кольцевой связный список, очередь.
 * Использовать только ссылку на last
 */
public class CircularQueue<T> implements QueueInterface<T> {
    private Node<T> last; // самый свежий узел
    private int n;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void enqueue(T item) {
        if (last == null) {
            last = new Node<>();
            last.item = item;
            last.next = last;
        } else {
            Node<T> oldLast = last;
            last = new Node<>();
            last.item = item;
            last.next = oldLast.next;
            oldLast.next = last;
        }
        n++;
    }

    @Override
    public T dequeue() {
        if (size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = last.next.item;
        last.next = last.next.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Iterator not implemented");
    }
}

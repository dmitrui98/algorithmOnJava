package common.data.structure.queue;

import common.data.structure.util.Node;
import common.data.structure.util.base.QueueInterface;
import common.data.structure.util.iterator.LinkedIterator;
import java.util.Iterator;

/**
 * Листинг 1.3.8. Алгоритм 1.3. Очередь
 */
public class LinkedListQueue<T> implements QueueInterface<T> {
    private Node<T> first; // самый старый узел
    private Node<T> last; // самый свежий узел
    private int n;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
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

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(first);
    }
}

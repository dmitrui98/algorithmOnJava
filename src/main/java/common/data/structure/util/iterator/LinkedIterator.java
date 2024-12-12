package common.data.structure.util.iterator;

import common.data.structure.util.Node;
import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T> {
    private Node<T> current;

    public LinkedIterator(Node<T> first) {
        this.current = first;
    }

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

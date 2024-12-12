package common.data.structure.bag;

import common.data.structure.util.Node;
import common.data.structure.util.base.BagInterface;
import common.data.structure.util.iterator.RandomIterator;
import java.util.Iterator;

public class RandomBag<T> implements Iterable<T>, BagInterface<T> {
    private Node<T> first = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (isEmpty()) {
            first = new Node<>(item);
        } else {
            Node<T> node = new Node<>(item);
            node.next = first;
            first = node;
        }
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomIterator<>(first, size);
    }
}

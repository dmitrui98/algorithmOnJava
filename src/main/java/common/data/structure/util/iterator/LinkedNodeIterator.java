package common.data.structure.util.iterator;

import common.data.structure.util.Node;
import java.util.Iterator;

public class LinkedNodeIterator<T> implements Iterator<Node<T>> {
    private Node<T> current;

    public LinkedNodeIterator(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node<T> next() {
        Node<T> result = current;
        current = current.next;
        return result;
    }
}

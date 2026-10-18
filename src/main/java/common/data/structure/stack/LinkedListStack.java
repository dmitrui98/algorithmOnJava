package common.data.structure.stack;

import common.data.structure.util.Node;
import common.data.structure.util.base.StackInterface;
import common.data.structure.util.iterator.LinkedIterator;
import java.util.Iterator;

/**
 * Листинг 1.3.6. Алгоритм 1.2
 * Стек. Реализация на основе связного списка
 */
public class LinkedListStack<T> implements StackInterface<T> {
    /**
     * Верхушка стека
     */
    private Node<T> first;

    /**
     * Количество элементов
     */
    private int n;

    public LinkedListStack() {
    }

    public LinkedListStack(StackInterface<T> stack) {
        StackInterface<T> temp = new LinkedListStack<>();
        for (T item : stack) {
            temp.push(item);
        }
        while (!temp.isEmpty()) {
            this.push(temp.pop());
        }
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
    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public T peek() {
        return first.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(first);
    }
}

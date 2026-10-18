package common.data.structure.util.base;

public interface Deque<T> extends Iterable<T> {
    boolean isEmpty();

    int size();

    void pushLeft(T element);

    void pushRight(T element);

    T popLeft();

    T popRight();

    T removeAt(int index);
}

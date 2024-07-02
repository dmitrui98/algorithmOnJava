package common.data.structure.queue;


public interface Queue<T> extends Iterable<T> {
    boolean isEmpty();
    int size();

    /**
     * Добавление элемента в конец очереди
     */
    void enqueue(T item);

    /**
     * Удаление элемента из начала очереди
     */
    T dequeue();
}

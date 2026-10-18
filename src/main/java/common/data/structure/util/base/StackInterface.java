package common.data.structure.util.base;

public interface StackInterface<T> extends Iterable<T> {
    boolean isEmpty();

    int size();

    /**
     * Добавление элемента в начало стека
     */
    void push(T item);

    /**
     * Извлечение элемента из начала стека с удалением
     */
    T pop();

    /**
     * Извлечение элемента из начала стека без удаления
     */
    T peek();
}

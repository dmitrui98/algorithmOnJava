package common.data.structure.util.base;

public interface RandomQueueInterface<T> extends QueueInterface<T> {

    /**
     * Извлечение и возврат случайного элемента.
     * Выборка без замены
     */
    T dequeue();

    /**
     * Возврат случайного элемента без удаления.
     * Выборка с заменой
     */
    T sample();
}

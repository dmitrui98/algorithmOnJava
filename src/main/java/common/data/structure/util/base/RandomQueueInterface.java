package common.data.structure.util.base;

public interface RandomQueueInterface<T> extends QueueInterface<T> {
    /**
     * Возврат случайного элемента без удаления.
     * Выборка с заменой - [что это значит??]
     */
    T sample();
}

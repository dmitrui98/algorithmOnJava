package common.data.structure.util.iterator;

import common.data.structure.util.Node;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIterator<T> implements Iterator<T> {
    private final T[] randomArray;
    private final int size;
    private int currentIndex;

    public RandomIterator(Node<T> first, int size) {
        @SuppressWarnings("unchecked")
        T[] a = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = first.item;
            first = first.next;
        }
        // перемешать массив
        Random r = ThreadLocalRandom.current(); // безопасный рандом для многопоточной среды
        for (int i = size - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            T temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        // Collections.shuffle(Arrays.asList(a));
        this.randomArray = a;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        return randomArray[currentIndex++];
    }
}

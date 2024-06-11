package lesson2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class C5_VisualCounter {
    private final int n; // максимальное количество операций
    private final int max; // максимальное значение для счетчика
    private int count = 0;
    private int countOperations = 0;
    private double y = 20;

    public C5_VisualCounter(int n, int max) {
        this.n = n;
        this.max = max;
        int absMax = Math.abs(max);
        StdDraw.setScale(absMax * -1, absMax);
    }

    public void increment() {
        checkOperationsCount();
        checkCountMaxValue();
        countOperations++;
        count++;
        StdDraw.point(count, countOperations);
    }

    public void decrement() {
        checkOperationsCount();
        checkCountMaxValue();
        countOperations++;
        count--;
        StdDraw.point(count, countOperations);
    }

    private void checkOperationsCount() {
        if (countOperations >= n) {
            throw new RuntimeException("Max count of operations is reached: " + countOperations);
        }
    }

    private void checkCountMaxValue() {
        int absCount = Math.abs(count);
        if (absCount >= max) {
            throw new RuntimeException("Max count value (abs) is reached: " + absCount);
        }
    }

    @Override
    public String toString() {
        return String.format("N: %s; max: %s; countOperations: %s; count: %s", n, max, countOperations, count);
    }

    public static void main(String[] args) {
        int n = 50;
        int max = 100;
        C5_VisualCounter vc = new C5_VisualCounter(n, max);
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli()) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }
        //vc.increment();
        StdOut.println(vc);
    }
}

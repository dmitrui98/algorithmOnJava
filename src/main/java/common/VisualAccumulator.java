package common;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator {
    private final Accumulator accumulator = new Accumulator();
    private double total;
    private int n;

    /**
     *
     * @param trials количество вводимых точек
     * @param max максимальное значение для масштабирования чертежа
     */
    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        accumulator.addDataValue(val);
        n++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, total / n);
    }

    @Override
    public String toString() {
        return accumulator.toString();
    }
}

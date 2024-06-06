package lesson2;

import edu.princeton.cs.algs4.*;
import util.Pair;

import java.awt.*;

/**
 * Введите N, min, max.
 * Код генерирует на единичном квадрате N случайных двумерных интервалов, ширины и высоты которых
 * равномерно распределены между min и max. Начертите их на StdDraw и выведите количество пересекающихся
 * пар интервалов и количество интервалов, содержащихся один в другом
 */
public class C3_Interval2DClient {
    private static final Double minScale = 0.0;
    private static final Double maxScale = 100.0;
    public static void main(String[] args) {
        StdDraw.setScale(minScale, maxScale);
        StdOut.print("Введите количество интервалов: ");
        int n = StdIn.readInt();
        StdIn.readLine();

        StdOut.print("Введите min: ");
        double inputMin = StdIn.readDouble();
        StdIn.readLine();

        StdOut.print("Введите max: ");
        double inputMax = StdIn.readDouble();
        StdIn.readLine();
        double maxLength = inputMax - inputMin;

        Interval2D[] intervals = new Interval2D[n];
        Pair<Point2D, Point2D>[] intervalCoordinates = new Pair[n];
        for (int i = 0; i < n; i++) {
            Interval1D x = getInterval(maxLength);
            Interval1D y = getInterval(maxLength);
            Interval2D interval = new Interval2D(x, y);
            interval.draw();
            Point2D left = new Point2D(x.min(), y.min());
            Point2D right = new Point2D(x.max(), y.max());
            intervalCoordinates[i] = new Pair<>(left, right);
            intervals[i] = interval;
        }

        int countIntersect = 0;
        int countInside = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdDraw.setPenColor(Color.RED);
                    countIntersect++;
                    intervals[i].draw();
                    intervals[j].draw();
                }
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) {
                    continue;
                }
                Pair<Point2D, Point2D> coord = intervalCoordinates[j];
                if (isIntervalContains(intervals[i], coord)) {
                    StdDraw.setPenColor(Color.GREEN);
                    countInside++;
                    intervals[j].draw();
                }
            }
        }
        StdOut.println("Количество пересечений: " + countIntersect);
        StdOut.println("Количество внутренних интервалов: " + countInside);
    }

    private static boolean isIntervalContains(Interval2D interval, Pair<Point2D, Point2D> coord) {
        return interval.contains(coord.getFirst()) && interval.contains(coord.getSecond());
    }

    private static Interval1D getInterval(double maxLength) {
        double x = StdRandom.uniformDouble(minScale, maxScale - maxLength);
        double x1 = StdRandom.uniformDouble(x, x + maxLength);
        return new Interval1D(x, x1);
    }
}

package lesson1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.util.Arrays;

/**
 * 1.1.32
 * Гистограмма
 * Решена неверно!
 */
public class A32_Histogram {
    public static void main(String[] args) {
        In file = new In("input.txt");
        double[] a = file.readAllDoubles();
        Arrays.sort(a);
        for (double v : a) {
            StdOut.print(v + " ");
        }
        StdOut.println();
        StdOut.print("Введите n: ");
        //int n = StdIn.readInt();
        int n = 5;

        StdOut.print("Введите l: ");
        //double l = StdIn.readDouble();
        double l = 3.1;

        StdOut.print("Введите r: ");
        //double r = StdIn.readDouble();
        double r = 6.2;

        StdDraw.setScale(-5, 10);
        double halfWidth = (Math.abs(l - r) / n) / 2;
        StdDraw.line(0, 0, 0, 5);
        StdDraw.line(0, 0, 5, 0);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.setPenColor(StdDraw.RED);
            }
            double x = i * halfWidth * 2.0 + halfWidth;
            double x1 = x - halfWidth;
            double x2 = x + halfWidth;
            int countIntervalNumbers = 0;
            while (j < a.length && a[j] >= x1 && a[j] <= x2) {
                j++;
                countIntervalNumbers++;
            }
            StdOut.printf("Interval (%.2f, %.2f); count: %d\n", x1, x2, countIntervalNumbers);
            double halfHeight = 0.2 * countIntervalNumbers / 2.0;
            double y = halfHeight;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }
}

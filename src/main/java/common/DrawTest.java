package common;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class DrawTest {

    public static void main(String[] args) {
//         drawFunctions(200);
         drawRandomArray(500, true);
//        test();
    }

    private static void test() {
        // масштаб
        StdDraw.setScale();

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(0.30, 0.30, 0.60, 0.20);
        StdDraw.circle(0.5, 0.5, 0.5);
        StdDraw.point(0.5, 0.5);
        StdDraw.square(0.5, 0.5, 0.2);

        double[] x = {0.1, 0.2, 0.3, 0.5};
        double[] y = {0.1, 0.2, 0.3, 0.6};
        StdDraw.filledPolygon(x, y);
    }

    private static void drawRandomArray(int n, boolean isSort) {
        double[] array = getRandomArray(n);
        if (isSort) {
            Arrays.sort(array);
        }
        for (int i = 0; i < n; i++) {
            double x = 1.0 * i / n;
            double y = array[i] / 2.0;
            double halfWidth = 0.5 / n;
            double halfHeight = array[i] / 2.0;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }

    private static void drawFunctions(int n) {
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n * n);

        for (int i = 1; i <= n; i++) {

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i, i);

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, i * i);

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    private static double[] getRandomArray(int n) {
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformDouble();
        }
        return a;
    }

}

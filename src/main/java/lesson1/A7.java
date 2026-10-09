package lesson1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.7
 * Что выведет данный код?
 */
public class A7 {
    public static void main(String[] args) {
        // a)
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
        // б)
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
        // в)
        sum = 0;
        int n = 1000;
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }
}

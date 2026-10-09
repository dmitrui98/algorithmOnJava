package lesson1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.19
 */
public class A19_Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            StdOut.println(i + " " + f(i));
        }
    }

    private static long f(int n) {
        if (n == 0) return 0;
        long[] a = new long[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    private static long recursiveF(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveF(n - 1) + recursiveF(n - 2);
    }
}

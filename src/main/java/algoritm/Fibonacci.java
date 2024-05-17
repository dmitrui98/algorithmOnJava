package algoritm;

import static edu.princeton.cs.algs4.StdOut.println;

public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 80; i++) {
            println(i + " " + fibonacci(i));
        }
    }

    public static long fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        long[] a = new long[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}

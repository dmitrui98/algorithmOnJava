package lesson1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.20
 * Рекурсивное вычисление ln(N!)
 */
public class A20_lnFactorial {
    public static void main(String[] args) {
        StdOut.println(ln(5));
        StdOut.println(Math.log(120)); // 5!
    }

    private static double ln(int n) {
        if (n <= 1) return 0.0;
        return Math.log(n) + ln(n - 1);
    }
}

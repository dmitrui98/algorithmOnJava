package lesson1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.16
 * Приведите значение exR1(6)
 */
public class A16 {
    public static void main(String[] args) {
        StdOut.println(exR1(6)); // 311361142246
    }

    private static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}

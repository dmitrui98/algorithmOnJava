package lesson1;

import static edu.princeton.cs.algs4.StdOut.println;

public class Binomial {

    public static void main(String[] args) {
        println(binomial(10, 5, 0.5));
    }

    private static double binomial(int n, int k, double p) {
        println("hey");
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
    }
}

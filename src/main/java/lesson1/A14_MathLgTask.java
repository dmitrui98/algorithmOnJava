package lesson1;

import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1.1.14
 */
public class A14_MathLgTask {

    public static void main(String[] args) {
        print("Input N for lg: ");
        int n = StdIn.readInt();
        println(lg(n));
    }

    /**
     * Наибольшее целое число, которое не привышает log2 N
     */
    private static int lg(int n) {
        // найти степень, в которую нужно возвести число 2, чтобы получить N
        double a = 1;
        int degree = 0;
        while (a < n) {
            a *= 2;
            if (a <= n) {
                degree++;
            }
        }
        return degree;
    }
}

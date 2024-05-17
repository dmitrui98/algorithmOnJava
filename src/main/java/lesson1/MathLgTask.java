package lesson1;

import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class MathLgTask {

    public static void main(String[] args) {
//        print("Input N for lg: ");
//        int n = StdIn.readInt();
//        println(lg(n));

        print("Input N for ln(N!): ");
        int n = StdIn.readInt();
        println(ln(n));


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

    /**
     * Рекурсивное вычисление ln(N!)
     */
    private static double ln(int n) {
        if (n <= 1) {
            return 0;
        }
        double e = Math.E; // и че с этим делать??
        return ln(n) + ln(n - 1);
    }
}

package algoritm;

import edu.princeton.cs.algs4.StdIn;
import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1.1.24
 */
public class Euclid {

    public static void main(String[] args) {
        print("Input A: ");
        int a = StdIn.readInt();
        print("Input B: ");
        int b = StdIn.readInt();
        println(String.format("НОД(%d, %d): %d", a, b, greatestCommonDivider(a, b)));
    }

    public static long greatestCommonDivider1(long x, long y) {
        if (y == 0) {
            return x;
        }
        long reminder = x % y;
        return greatestCommonDivider1(y, reminder);
    }

    public static long greatestCommonDivider(long x, long y) {
        long temp;
        while (x != 0) {
            temp = x;
            x = y % x;
            y = temp;
        }
        return y;
    }
}

package lesson1;

import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.*;

public class Euclid {

    public static void main(String[] args) {
        print("Input A: ");
        int a = StdIn.readInt();
        print("Input B: ");
        int b = StdIn.readInt();
        println(String.format("НОД(%d, %d): %d", a, b, greatestCommonDivider(a, b)));
    }

    public static long greatestCommonDivider(long x, long y) {
        //printf("x = %-5d; y = %-5d\n", x, y);
        if (y == 0) {
            return x;
        }
        long reminder = x % y;
        return greatestCommonDivider(y, reminder);
    }
}

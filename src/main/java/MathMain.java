import edu.princeton.cs.algs4.StdRandom;
import util.ArrayUtil;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class MathMain {
    public static void main(String[] args) {
         chapter1_1();
    }

    private static void chapter1_1() {
        long abs = Math.abs(-2147483648); // overflow of int primitive type
        println("ABS: " + abs);
        println("INT MIN: " + Integer.MIN_VALUE);
        println("INT MAX: " + Integer.MAX_VALUE);
        println("LONG MIN: " + Long.MIN_VALUE);
        println("LONG MAX: " + Long.MAX_VALUE);

        println("Positive infinity: " + Double.POSITIVE_INFINITY);
        println("Negative infinity: " + Double.NEGATIVE_INFINITY);
        println("One more positive infinity: " + 1.0 / 0.0);
        // println(1 / 0); ArithmeticException: device by zero - for int values

        printf("-14 / 3 = %d\n", -14 / 3);
        printf("14 / -3 = %d\n", 14 / -3);
        printf("-14 %% 3 = %d\n", -14 % 3); // (a / b) * b + a % b == a
        printf("14 %% -3 = %d\n", 14 % -3);
    }
}

package lesson1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.5
 */
public class A5 {
    public static void main(String[] args) {
        StdOut.print("Введите x: ");
        double x = StdIn.readDouble();
        StdOut.print("Введите y: ");
        double y = StdIn.readDouble();
        boolean fl = (x > 0 && x < 1) && (y > 0 && y < 1);
        StdOut.println("Находятся строго между 0 и 1: " + fl);
    }
}

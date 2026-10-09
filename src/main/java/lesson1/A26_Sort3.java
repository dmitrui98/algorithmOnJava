package lesson1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.26
 * Сортировка трех чисел
 */
public class A26_Sort3 {
    public static void main(String[] args) {
        StdOut.print("Введите a: ");
        int a = StdIn.readInt();
        StdOut.print("Введите b: ");
        int b = StdIn.readInt();
        StdOut.print("Введите с: ");
        int c = StdIn.readInt();
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        StdOut.println(a + " " + b + " " + c);
    }
}

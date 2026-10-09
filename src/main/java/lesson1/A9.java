package lesson1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.9
 */
public class A9 {
    public static void main(String[] args) {
        String s = "";
        StdOut.print("Введите n: ");
        int n = StdIn.readInt();
        for (int i = n; i > 0 ; i /= 2) {
            s = (i % 2) + s;
        }
        StdOut.println(s);
    }
}

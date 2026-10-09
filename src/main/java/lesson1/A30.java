package lesson1;

import algoritm.Euclid;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

/**
 * 1.1.30
 * Работа с массивом
 */
public class A30 {
    public static void main(String[] args) {
        StdOut.print("Input n: ");
        int n = StdIn.readInt();
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (Euclid.greatestCommonDivider(i, j) == 1) {
                    a[i][j] = true;
                } else {
                    a[i][j] = false;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                StdOut.printf("%6s", a[i][j]);
            }
            StdOut.println();
        }
    }
}

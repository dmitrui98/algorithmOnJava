package lesson1;

import util.ArrayUtil;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class ArrayTranspositionTask {
    public static void main(String[] args) {
        int m = 5;
        int n = 10;
        int[][] a = ArrayUtil.getIntRandomArray(m, n);
        ArrayUtil.printArray(a);
        println("*********");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                printf("%3s", a[j][i]);
            }
            println();
        }
    }
}

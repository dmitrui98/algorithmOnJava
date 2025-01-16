package util;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class ArrayUtil {

    /**
     * @param m - count rows
     * @param n - count columns
     * @return array with random values
     */
    public static boolean[][] getBoolRandomArray(int m, int n) {
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdRandom.bernoulli();
            }
        }
        return a;
    }

    public static int[][] getIntRandomArray(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdRandom.uniformInt(100);
            }
        }
        return a;
    }

    public static int[] getIntRandomArray(int n, int borderLeft, int borderRight) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(borderLeft, borderRight);
        }
        return a;
    }

    public static int[] getIntRandomArrayBorder(int n, int border) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(border);
        }
        return a;
    }

    public static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int value : row) {
                printf("%3s", value);
            }
            println();
        }
    }

    public static void printArray(int[] a) {
        for (int anInt : a) {
            printf("%8s", anInt);
        }
        println();
    }

    public static void print(Iterable<?> list) {
        for (Object o : list) {
            StdOut.print(o + " ");
        }
        StdOut.println();
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        return collection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}

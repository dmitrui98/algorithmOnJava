package lesson1;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.util.Arrays;

/**
 * 1.1.22
 */
public class A22_BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,  3,  9, 10, 12, 15, 16, 19, 20, 21, 22, 25, 26, 27, 29, 30, 31, 35, 36, 37, 43, 48, 50};
        Arrays.sort(a);
        ArrayUtil.printArray(a);
        StdOut.println("Индекс найденного элемента: " + rank(22, a, 0, a.length - 1, 0));
    }

    private static int rank(int key, int[] a, int lo, int hi, int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
        }
        StdOut.printf("%slo: %d, hi: %d, depth: %d\n", indent.toString(), lo, hi, depth);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, depth + 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, depth + 1);
        } else {
            return mid;
        }
    }
}

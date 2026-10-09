package lesson2;

import algoritm.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Рис. 1.2.26
 */
public class A6_StaticSetOfInts {
    private int[] a;

    public static void main(String[] args) {
        In file = new In("largeW.txt");
        int[] w = file.readAllInts();
        A6_StaticSetOfInts set = new A6_StaticSetOfInts(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (set.contains(key)) {
                StdOut.println(key + " содержится в списке");
            } else {
                StdOut.println(key + " не содержится в списке");
            }
        }
    }

    public A6_StaticSetOfInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return search(key) != -1;
    }

    private int search(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

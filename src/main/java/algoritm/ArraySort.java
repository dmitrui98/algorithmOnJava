package algoritm;

import util.ArrayUtil;

public class ArraySort {

    public static void main(String[] args) {
        int[] a = {1, 3, 2};
        ArrayUtil.printArray(a);
        sort3Numbers(a);
        ArrayUtil.printArray(a);
    }

    public static void sort3Numbers(int[] a) {
        if (a.length != 3) {
            throw new IllegalArgumentException("Array length must be 3 for sort 3");
        }
        if (a[0] > a[1]) {
            swap(a, 0, 1);
        }
        if (a[0] > a[2]) {
            swap(a, 0, 2);
        }
        if (a[1] > a[2]) {
            swap(a, 1, 2);
        }
    }

    private static void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }
}

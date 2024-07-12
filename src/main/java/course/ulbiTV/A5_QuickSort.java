package course.ulbiTV;

import util.ArrayUtil;

/**
 * Быстрая сортировка (сортировка Хоара)
 * Сложность O(n*log2n)
 */
public class A5_QuickSort {
    private static int count = 0;

    public static void main(String[] args) {
        A5_QuickSort sort = new A5_QuickSort();
        int[] a = {0,3,2,5,6,8,1,9,4,2,1,2,9,6,4,1,7,-1,-5,23,6,2,35,6,3,32};
        ArrayUtil.printArray(a);
        sort.quickSort(a);
        ArrayUtil.printArray(a);
        System.out.printf("Count iterations: %s; array length: %s", count, a.length);
    }

    private void quickSort(int[] a) {

    }
}

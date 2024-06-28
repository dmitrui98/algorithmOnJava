package course.ulbiTV;

import util.ArrayUtil;

/**
 * Сложность O(1/2*n^2) = O(n^2)
 */
public class A3_SelectionSort {
    private static int count = 0;

    public static void main(String[] args) {
        A3_SelectionSort sort = new A3_SelectionSort();
        int[] a = {0,3,2,5,6,8,1,9,4,2,1,2,9,6,4,1,7,-1,-5,23,6,2,35,6,3,32};
        ArrayUtil.printArray(a);
        sort.selectionSort(a);
        ArrayUtil.printArray(a);
        System.out.printf("Count iterations: %s; array length: %s", count, a.length);
    }

    private void selectionSort(int[] a) {
        count = 0;
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
                count++;
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }
}

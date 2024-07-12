package course.ulbiTV;

import util.ArrayUtil;

/**
 * Пузырьковая сортировка
 * Сложность O(n^2)
 */
public class A4_BubbleSort {
    private static int count = 0;

    public static void main(String[] args) {
        A4_BubbleSort sort = new A4_BubbleSort();
        int[] a = {0,3,2,5,6,8,1,9,4,2,1,2,9,6,4,1,7,-1,-5,23,6,2,35,6,3,32};
        ArrayUtil.printArray(a);
        sort.bubbleSort(a);
        ArrayUtil.printArray(a);
        System.out.printf("Count iterations: %s; array length: %s", count, a.length);
    }

    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
                count++;
            }
        }
    }
}

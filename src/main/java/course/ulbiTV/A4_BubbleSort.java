package course.ulbiTV;

import util.ArrayUtil;

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

    }
}

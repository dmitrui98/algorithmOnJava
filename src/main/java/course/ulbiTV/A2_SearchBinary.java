package course.ulbiTV;

import util.ArrayUtil;

/**
 * Сложность O(log2n)
 */
public class A2_SearchBinary {
    private static int count = 0;

    public static void main(String[] args) {
        A2_SearchBinary search = new A2_SearchBinary();
        int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        ArrayUtil.printArray(a);
        int searchItem = 2;
        Integer index = search.searchBinary(a, searchItem);
        System.out.printf("Search item: %s; index: %s; countIterations: %s\n", searchItem, index, count);

        System.out.println("Recursive:");
        count = 0;
        index = search.searchBinaryRecursive(a, searchItem, 0, a.length - 1);
        System.out.printf("Search item: %s; index: %s; countIterations: %s", searchItem, index, count);
    }

    public Integer searchBinary(int[] a, int item) {
        count = 0;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            count++;
            int middle = (start + end) / 2;
            if (a[middle] == item) {
               return middle;
            } else if (item < a[middle]) {
               end = middle - 1;
            } else {
               start = middle + 1;
            }
        }
        return null;
    }

    public Integer searchBinaryRecursive(int[] a, int item, int start, int end) {
        count++;
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        if (a[middle] == item) {
            return middle;
        } else if (item < a[middle]) {
            return searchBinaryRecursive(a, item, start, middle - 1);
        } else {
            return searchBinaryRecursive(a, item, middle + 1, end);
        }
    }
}

package lesson1;

import algoritm.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.util.Arrays;

/**
 * 1.1.29
 */
public class A29_EqualKeys {
    public static void main(String[] args) {
        In file = new In("tinyT.txt");
        int[] a = file.readAllInts();
        Arrays.sort(a);
        ArrayUtil.printArray(a);
        StdOut.print("Input key: ");
        int key = StdIn.readInt();
        StdOut.printf("Count elements less key (key: %d): %d\n", key, countElementsLessKey(key, a));
        StdOut.printf("Count elements (key: %d): %d\n", key, countKey(key, a));
    }

    public static int countKey(int key, int[] sortedArray) {
        Integer index = BinarySearch.search(key, sortedArray);
        if (index == null) {
            return 0;
        }
        int count = 1;
        int i = index - 1;
        while (i >= 0 && key == sortedArray[i]) {
            i--;
            count++;
        }
        StdOut.println("Found index: " + index);
        i = index + 1;
        while (i < sortedArray.length && key == sortedArray[i]) {
            i++;
            count++;
        }
        return count;
    }

    public static int countElementsLessKey(int key, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (key < sortedArray[middle]) {
                right = middle - 1;
            } else if (key > sortedArray[middle]) {
                left = middle + 1;
            } else {
                int i = middle;
                while (i >= 0 && sortedArray[i] == key) {
                    i--;
                }
                return i + 1;
            }
        }
        return left;
    }
}

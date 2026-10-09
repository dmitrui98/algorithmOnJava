package lesson1;

import edu.princeton.cs.algs4.In;
import util.ArrayUtil;
import java.util.Arrays;

/**
 * 1.1.28
 */
public class A28_RemoveDuplicates {
    public static void main(String[] args) {
        In file = new In("tinyT.txt");
        int[] a = file.readAllInts();
        Arrays.sort(a);
        ArrayUtil.printArray(a);
        int[] a1 = removeDuplicates(a);
        ArrayUtil.printArray(a1);
    }

    private static int[] removeDuplicates(int[] sortedArray) {
        int[] result = new int[sortedArray.length];
        int j = 0;
        result[j] = sortedArray[j];
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] == sortedArray[i - 1]) {
                continue;
            }
            result[++j] = sortedArray[i];
        }
        return result;
    }
}

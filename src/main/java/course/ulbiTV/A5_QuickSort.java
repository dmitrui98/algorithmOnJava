package course.ulbiTV;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.ArrayUtil.toIntArray;
import static util.ArrayUtil.toList;

/**
 * Быстрая сортировка (сортировка Хоара)
 * Сложность O(n*log2n)
 */
public class A5_QuickSort {
    private static int count = 0;

    public static void main(String[] args) {
        A5_QuickSort sort = new A5_QuickSort();
        int[] a = {0,3,2,5,6,23,1,9,4,2,1,2,9,6,4,1,7,-1,-5,23,6,2,35,6,3,32,23,1,9,4,2,1,2,9,6,23,1,9,4,2,1,2,9,6,23,1,9,499,2,1,2,9,6};
        ArrayUtil.printArray(a);
        a = sort.quickSort(a);
        ArrayUtil.printArray(a);
        System.out.printf("Count iterations: %s; array length: %s", count, a.length);
    }

    private int[] quickSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int pivotIndex = a.length / 2;
        int pivot = a[pivotIndex];
        List<Integer> lessList = new ArrayList<>();
        List<Integer> greaterList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            count++;
            if (i == pivotIndex) {
                continue;
            }
            if (a[i] < pivot) {
                lessList.add(a[i]);
            } else {
                greaterList.add(a[i]);
            }
        }
        List<Integer> resultList = toList(quickSort(toIntArray(lessList)));
        resultList.add(pivot);
        resultList.addAll(toList((quickSort(toIntArray(greaterList)))));
        return toIntArray(resultList);
    }
}

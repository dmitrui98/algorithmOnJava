package algoritm;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.time.Instant;
import java.util.Arrays;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class BinarySearch {

    private static final String PATH = "data/binarySearch/";

    public static void main(String[] args) {
        staticTest();
         //fileTest(false);

//        duplicateTest();
    }

    private static void duplicateTest() {
        int[] whitelist = new In("tinyWDuplicate.txt").readAllInts();
        Arrays.sort(whitelist);
        ArrayUtil.printArray(whitelist);
        int[] withoutDuplicates = removeDuplicates(whitelist);
        ArrayUtil.printArray(withoutDuplicates);
    }

    private static void fileTest(boolean findNotFound) {
        // String whiteListPath = PATH + "whiteList.txt";
        String whiteListPath = "tinyW.txt";
        // String inPath = PATH + "in.txt";
        String inPath = "tinyT.txt";
        int[] whitelist = new In(whiteListPath).readAllInts();
        Arrays.sort(whitelist);

        In in = new In(inPath);
        Out out = new Out(PATH + "out.txt");

        long before = Instant.now().toEpochMilli();
        while (!in.isEmpty()) {
            int key = in.readInt();

            if (findNotFound) {
                if (search(key, whitelist) == null) {
                    String msg = "Not found: %s\n";
                    StdOut.printf(msg, key);
                    // out.printf(msg, key);
                }
            } else {
                if (search(key, whitelist) != null) {
                    String msg = "Found: %s\n";
                    StdOut.printf(msg, key);
                    // out.printf(msg, key);
                }
            }
        }
        long after = Instant.now().toEpochMilli();
        StdOut.print("Execution time (millis): ");
        println(after - before);
    }

    private static void staticTest() {
        int[] array = {3, 1, 2, 88, 77, 12, 55, 10};
        Arrays.sort(array);
        System.out.println("Sorted array: ");
        for (int element : array) {
            System.out.print(element + ", ");
        }
        int key = 10;
        System.out.println("\nSearched key: " + key);
        Counter counter = new Counter("searched keys");
        Integer result = searchCounter(key, array, counter);
        System.out.println("Result: " + result);
        StdOut.println(counter);

        result = searchRecursive(key, array);
        System.out.println("Result recursive: " + result);
    }

    public static Integer search(int key, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (key < sortedArray[middle]) {
                right = middle - 1;
            } else if (key > sortedArray[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return null;
    }

    public static Integer searchCounter(int key, int[] sortedArray, Counter counter) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            counter.increment();
            int middle = left + (right - left) / 2;
            if (key < sortedArray[middle]) {
                right = middle - 1;
            } else if (key > sortedArray[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return null;
    }

    public static Integer searchRecursive(int key, int[] sortedArray) {
        return searchRecursive(key, sortedArray, 0, sortedArray.length - 1, 0);
    }

    public static Integer searchSimple(int key, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return null;
    }

    private static Integer searchRecursive(int key, int[] array, int left, int right, int depth) {
        printf("Depth %d: left %d; right: %d\n", depth, left, right);
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        if (key < array[middle]) {
            return searchRecursive(key, array, left, middle - 1, depth + 1);
        } else if (key > array[middle]) {
            return searchRecursive(key, array, middle + 1, right, depth + 1);
        } else {
            return middle;
        }
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

    /**
     * TODO 1.1.29
     */

    public static Integer searchCount(int key, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (key < sortedArray[middle]) {
                right = middle - 1;
            } else if (key > sortedArray[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return null;
    }
}

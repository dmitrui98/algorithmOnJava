package lesson1;

import util.ArrayUtil;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class RandomBoolArrayTask {

    public static void main(String[] args) {
        boolean[][] a = ArrayUtil.getBoolRandomArray(10, 20);

        printHeader(a[0].length);
        for (int i = 0; i < a.length; i++) {
            printf("%-2d: ", i + 1);
            for (int j = 0; j < a[i].length; j++) {
                printf("%-4s", getValue(a[i][j]));
            }
            println();
        }
    }

    private static void printHeader(int countColumns) {
        printf("%4s", "");
        for (int i = 0; i < countColumns; i++) {
            printf("%-4d", i + 1);
        }
        println();
    }

    private static String getValue(boolean bool) {
        String value;
        if (bool) {
            value = "*";
        } else {
            value = "x";
        }
        return value;
    }
}

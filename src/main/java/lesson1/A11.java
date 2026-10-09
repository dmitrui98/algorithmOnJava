package lesson1;

import util.ArrayUtil;

/**
 * 1.1.11
 */
public class A11 {
    public static void main(String[] args) {
        boolean[][] a = ArrayUtil.getBoolRandomArray(10, 6);
        System.out.print(" ");
        for (int i = 0; i < a[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == 0) {
                    System.out.print(i);
                }
                if (a[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

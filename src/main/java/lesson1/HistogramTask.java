package lesson1;

import util.ArrayUtil;

import static edu.princeton.cs.algs4.StdOut.println;

public class HistogramTask {

    public static void main(String[] args) {
        int border = 10;
        int[] a = ArrayUtil.getIntRandomArrayBorder(20, border);
        ArrayUtil.printArray(a);

        int[] histogram = histogram(a, border);
        println("Histogram of count values:");
        ArrayUtil.printArray(histogram);

        int sum = 0;
        for (int element : histogram) {
            sum += element;
        }
        // если значения массива А находятся между 0 и M-1, то сумма должна быть равна длине массива A
        println("Histogram sum: " + sum);
    }

    /**
     * Возвращает массив длинной M,
     * i-й элемент которого равен количеству
     * появлений числа i в массиве A
     */
    private static int[] histogram(int[] a, int m) {
        int[] b = new int[m];
        for (int i = 0; i < b.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    count++;
                }
            }
            b[i] = count;
        }
        return b;
    }
}

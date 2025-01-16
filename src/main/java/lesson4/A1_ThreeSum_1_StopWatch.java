package lesson4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stopwatch;
import util.ArrayUtil;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class A1_ThreeSum_1_StopWatch {

    public static void main(String[] args) {
        println("Введите количество элементов в массиве:");
        int border = 1000000;
        int n = StdIn.readInt();
        int[] a = ArrayUtil.getIntRandomArray(n, -border, border);
        Stopwatch timer = new Stopwatch();
        int count = A1_ThreeSum.count(a);
        printf("Найдено %s троек чисел за %s секунд", count, timer.elapsedTime());
    }
}

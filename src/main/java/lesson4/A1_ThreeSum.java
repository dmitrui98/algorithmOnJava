package lesson4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * Листинг 1.4.1.
 * Количество троек чисел в массиве целых числел, которые дают в сумме 0.
 * где может пригодиться: например, упражнение 1.4.26
 * <br/>
 * Data:
 * <a href="https://algs4.cs.princeton.edu/14analysis/1Mints.txt">Файл с миллионом целых чисел</a>.
 * <br/>
 * <a href="https://algs4.cs.princeton.edu/14analysis/1Kints.txt">First 1000 from 1Mints.txt</a>
 * <a href="https://algs4.cs.princeton.edu/14analysis/2Kints.txt">First 2000 from 1Mints.txt</a>
 * <a href="https://algs4.cs.princeton.edu/14analysis/4Kints.txt">First 4000 from 1Mints.txt</a>
 * <a href="https://algs4.cs.princeton.edu/14analysis/8Kints.txt">First 8000 from 1Mints.txt</a>
 * <a href="https://algs4.cs.princeton.edu/14analysis/16Kints.txt">First 16000 from 1Mints.txt</a>
 * <a href="https://algs4.cs.princeton.edu/14analysis/32Kints.txt">First 32000 from 1Mints.txt</a>
 * Второе, восьмое и десятое число из этого файла дают в сумме 0.
 */
public class A1_ThreeSum {

    public static void main(String[] args) {
        In file = new In("data/lesson4/8Kints.txt");
        int[] array = file.readAllInts();
        //ArrayUtil.printArray(array);
        println("Array length: " + array.length);
        Stopwatch timer = new Stopwatch();
        println("Count triples: " + count(array));
        println("Elapsed time: " + timer.elapsedTime());
    }

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

package lesson4;

import edu.princeton.cs.algs4.Stopwatch;
import util.ArrayUtil;
import util.Pair;
import static edu.princeton.cs.algs4.StdOut.printf;

/**
 * Листинг 1.4.2.
 * Клиент тестирования времени выполнения в зависимости от количества обрабатываемых элементов.
 */
public class A1_ThreeSum_2_DoublingTest {

    public static void main(String[] args) {
        for (int n = 250; true; n *= 2) {
            Pair<Integer, Double> pair = timeTrial(n);
            printf("%7d %5.2f result: %d\n", n, pair.getSecond(), pair.getFirst());
        }
    }

    public static Pair<Integer, Double> timeTrial(int n) {
        int border = 1000000;
        int[] a = ArrayUtil.getIntRandomArray(n, -border, border);
        Stopwatch timer = new Stopwatch();
        int count = A1_ThreeSum.count(a);
        return new Pair<>(count, timer.elapsedTime());
    }
}

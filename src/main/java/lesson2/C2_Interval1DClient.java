package lesson2;

import edu.princeton.cs.algs4.*;
import util.Pair;

import java.awt.*;

/**
 * Клиент вводит целое число N, читает из стандартного ввода n интервалов (каждый определен парой значений double)
 * Выводит все пересекающие интервалы
 */
public class C2_Interval1DClient {
    public static void main(String[] args) {
        StdOut.print("Введите количество интервалов: ");
        int n = StdIn.readInt();
        StdIn.readLine();

        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            StdOut.printf("Введите min/max интервала через пробел (%s): ", i + 1);
            String[] split = StdIn.readLine().split(" ");
            double x = Double.parseDouble(split[0]);
            double x1 = Double.parseDouble(split[1]);
            intervals[i] = new Interval1D(x, x1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("Пересечение интервала %s: %s %s\n", i + 1, intervals[i], intervals[j]);
                    if (i < j) {
                        count++;
                    }
                }
            }
            StdOut.println();
        }
        StdOut.println("Количество пересечений: " + count);
    }
    /*
    Введите количество интервалов: 10
    Введите min/max интервала через пробел (0): 10 20
    Введите min/max интервала через пробел (1): 100 150
    Введите min/max интервала через пробел (2): 11 15
    Введите min/max интервала через пробел (3): 110 120
    Введите min/max интервала через пробел (4): 12 20
    Введите min/max интервала через пробел (5): 115 130
    Введите min/max интервала через пробел (6): 18 99
    Введите min/max интервала через пробел (7): 101 200
    Введите min/max интервала через пробел (8): 33 151
    Введите min/max интервала через пробел (9): 150 202
     */
}

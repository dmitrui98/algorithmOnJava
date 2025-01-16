package lesson3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * n = 10
 * 100
 * 99
 * 101
 * 120
 * 98
 * 107
 * 109
 * 81
 * 101
 * 90
 * <br/>
 * Result:
 * Среднее: 100.60
 * Среднеквадратичное откланение: 10.51
 */
public class A1_Stats {

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        StdOut.print("Введите количество элементов: ");
        int n = StdIn.readInt();
        for (int i = 0; i < n; i++) {
            numbers.add(StdIn.readDouble());
        }

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / n;

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (n - 1));

        StdOut.printf("Среднее: %.2f\n", mean);
        StdOut.printf("Среднеквадратичное откланение: %.2f\n", std);
    }
}

package lesson1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import util.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1.1.31
 * Случайные соединения
 */
public class A31_RandomConnection {
    public static void main(String[] args) throws InterruptedException {
        StdOut.print("Введите количество точек: ");
        int n = StdIn.readInt();
        StdOut.print("Введите вероятность соединения (между 0 и 1): ");
        double p = StdIn.readDouble();
        double r = 40;
        double scale = 50;
        StdDraw.setScale(0, scale * 2);
        StdDraw.point(50, 50);
        double x, y;
        List<Pair<Double, Double>> list = new ArrayList<>(n / 2);
        List<Pair<Double, Double>> list1 = new ArrayList<>(n / 2);
        for (int i = 0; i < n; i++) {
            x = scale + r * Math.cos((2 * Math.PI * i) / n);
            y = scale + r * Math.sin((2 * Math.PI * i) / n);
            StdDraw.filledCircle(x, y, 0.35);
            if (i < n / 2) {
                list.add(new Pair<>(x, y));
            } else {
                list1.add(new Pair<>(x, y));
            }
        }
        list.sort(Comparator.comparing(Pair::getFirst));
        list1.sort(Comparator.comparing(Pair::getFirst));
        Thread.sleep(1000);
        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < n / 2; i++) {
            if (StdRandom.bernoulli(p)) {
                StdDraw.line(
                    list.get(i).getFirst(),
                    list.get(i).getSecond(),
                    list1.get(i).getFirst(),
                    list1.get(i).getSecond()
                );
            }
            //Thread.sleep(250);
        }
    }
}

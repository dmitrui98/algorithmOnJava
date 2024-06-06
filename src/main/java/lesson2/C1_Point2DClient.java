package lesson2;

import edu.princeton.cs.algs4.*;
import util.Pair;

import java.awt.*;

/**
 * Напишите клиент класса Point2D, который принимает целое значение N, генерирует N случайных точек на единичном квадрате
 * и вычисляет расстояние между самой близкой парой точек
 */
public class C1_Point2DClient {
    public static void main(String[] args) {
        StdOut.print("Введите количество точек: ");
        int n = StdIn.readInt();
        StdDraw.setPenRadius(0.008);

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();
            Point2D point = new Point2D(x, y);
            point.draw();
            points[i] = point;
        }

        double minLength = Double.MAX_VALUE;
        Pair<Point2D, Point2D> pointsWithMinLength = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double l = points[i].distanceTo(points[j]);
                if (l < minLength) {
                    minLength = l;
                    pointsWithMinLength = new Pair<>(points[i], points[j]);
                }
            }
        }
        if (pointsWithMinLength != null) {
            StdDraw.setPenColor(Color.RED);
            pointsWithMinLength.getFirst().draw();
            pointsWithMinLength.getSecond().draw();
            StdOut.println("Минимальная длина между точками: " + minLength);
        } else {
            StdOut.println("Минимальное расстояние не найдено");
        }
    }
}

package lesson2;

import edu.princeton.cs.algs4.*;

public class Interval2DTest {

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);
        double xlo = 20;
        double xhi = 80;
        double ylo = 50;
        double yhi = 90;
        StdOut.print("Введите количество точек: ");
        int n = StdIn.readInt();

        Interval1D xInt = new Interval1D(xlo, xhi);
        Interval1D yInt = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xInt, yInt);
        box.draw();


        Counter c = new Counter("попаданий");
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniformDouble(0, 100);
            double y = StdRandom.uniformDouble(0, 100);
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                c.increment();
            } else {
                p.draw();
            }
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}

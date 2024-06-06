package lesson2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import common.VisualAccumulator;

public class B2_VisualAccumulatorTest {

    /**
     * !!! Код работает неверно
     */
    public static void main(String[] args) {
        StdOut.print("Введите количество элементов: ");
        int count = Integer.parseInt(StdIn.readLine());
        VisualAccumulator a = new VisualAccumulator(count, 1.0);
        for (int i = 0; i < count; i++) {
            a.addDataValue(StdRandom.uniformInt(100));
        }
        StdOut.println(a);
    }
}

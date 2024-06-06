package lesson2;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class B1_AccumulatorTest {

    public static void main(String[] args) {
        StdOut.print("Введите количество элементов: ");
        int count = Integer.parseInt(StdIn.readLine());
        Accumulator a = new Accumulator();
        for (int i = 0; i < count; i++) {
            a.addDataValue(StdRandom.uniformInt(100));
        }
        StdOut.println(a);
    }
}

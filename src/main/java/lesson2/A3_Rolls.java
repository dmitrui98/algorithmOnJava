package lesson2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class A3_Rolls {

    public static void main(String[] args) {
        StdOut.print("Input count rolls: ");
        int n = StdIn.readInt();
        int countSides = 6;
        Counter[] rolls = new Counter[countSides + 1];
        for (int i = 1; i <= countSides; i++) {
            rolls[i] = new Counter("выпадений " + i);
        }

        for (int i = 0; i < n; i++) {
            int result = StdRandom.uniformInt(1, countSides + 1);
            rolls[result].increment();
        }

        for (int i = 1; i <= countSides; i++) {
            StdOut.println(rolls[i]);
        }
    }
}

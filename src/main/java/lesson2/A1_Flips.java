package lesson2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Листинг 1.2.1; 1.2.2
 */
public class A1_Flips {

    public static void main(String[] args) {
        StdOut.print("Input count flips: ");
        int n = StdIn.readInt();
        Counter heads = new Counter("орлов");
        Counter tails = new Counter("решек");

        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int diff = heads.tally() - tails.tally();
        StdOut.println("Разница: " + Math.abs(diff));
        if (heads.tally() == tails.tally()) {
            StdOut.println("Ничья");
        } else {
            StdOut.println(max(heads, tails) + " победили");
        }
    }

    private static Counter max(Counter c, Counter c1) {
        if (c.tally() > c1.tally()) {
            return c;
        } else {
            return c1;
        }
    }
}

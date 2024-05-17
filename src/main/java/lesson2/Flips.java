package lesson2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {

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
    }
}

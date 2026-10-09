package lesson3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Листинг 1.3.3
 */
public class A001_Reverse {
    public static void main(String[] args) {
        In file = new In("tinyT.txt");
        Stack<Integer> stack = new Stack<>();
        while (!file.isEmpty()) {
            stack.push(file.readInt());
        }
        for (Integer i : stack) {
            StdOut.printf("%3d", i);
        }
    }
}

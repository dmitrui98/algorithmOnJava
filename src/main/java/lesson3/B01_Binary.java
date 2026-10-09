package lesson3;

import edu.princeton.cs.algs4.DoublingTest;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Упражнение 1.3.5.
 */
public class B01_Binary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        StdOut.print("Введите n: ");
        int n = StdIn.readInt();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        for (Integer i : stack) {
            StdOut.print(i);
        }
    }
}

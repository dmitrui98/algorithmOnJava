package lesson3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.util.ArrayList;

/**
 * Упражнение 1.3.37
 * Input: n: 7; m: 2
 * Output: 1 3 5 0 4 2 6
 */
public class B13_Josephus {
    public static void main(String[] args) {
        StdOut.print("Введите n: ");
        int n = StdIn.readInt();
        StdOut.print("Введите m: ");
        int m = StdIn.readInt();

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        ArrayUtil.print(queue);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
    }
}

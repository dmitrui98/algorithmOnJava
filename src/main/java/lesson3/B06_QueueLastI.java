package lesson3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Упражнение 1.3.15.
 * Input a b c d e f g h
 */
public class B06_QueueLastI {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        StdOut.print("Введите k: ");
        int k = StdIn.readInt();
        StdOut.println("Введите строки через пробел:");
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        int i = 0;
        int length = queue.size();
        while (!queue.isEmpty()) {
            if (i == length - k) {
                StdOut.print(queue.dequeue());
                break;
            }
            queue.dequeue();
            i++;
        }
    }
}

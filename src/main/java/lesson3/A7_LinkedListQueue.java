package lesson3;


import common.data.structure.queue.LinkedListQueue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.END_MARKER;

/**
 * Листинг 1.3.8. Алгоритм 1.3. Очередь
 * to be or not to - be - - that - - - is
 * Result: to be or not to be
 */
public class A7_LinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String item = StdIn.readString();
            if (END_MARKER.equals(item)) {
                break;
            }
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                sb.append(queue.dequeue()).append(" ");
            }
            StdOut.printf("Current capacity (%s): size: %s\n", ++i, queue.size());
        }
        StdOut.print(sb.toString());
        StdOut.println("(в очереди осталось " + queue.size() + ")");
        for (String s1 : queue) {
            StdOut.println("Элемент очереди: " + s1);
        }
    }
}

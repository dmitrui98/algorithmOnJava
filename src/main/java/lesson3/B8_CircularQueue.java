package lesson3;

import common.data.structure.queue.CircularQueue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Упражение 1.3.29. Кольцевой связный список, очередь.
 * Использовать только ссылку на last
 */
public class B8_CircularQueue {

    public static void main(String[] args) {
        B8_CircularQueue instance = new B8_CircularQueue();
        instance.go();
    }

    private void go() {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.enqueue("a");
        StdOut.println(queue.dequeue());
        StdOut.println("Queue size: " + queue.size());
        queue.enqueue("b");
        queue.enqueue("c");
        StdOut.println(queue.dequeue());
        StdOut.println("Queue size: " + queue.size());
        StdOut.println(queue.dequeue());
        StdOut.println("Queue size: " + queue.size());

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        StdOut.println("Queue size: " + queue.size());

        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println("Queue size: " + queue.size());
    }
}

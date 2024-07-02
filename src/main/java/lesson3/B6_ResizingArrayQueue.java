package lesson3;

import common.data.structure.queue.ResizingArrayQueueOfStrings;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.END_MARKER;

/**
 * Упражнение 1.3.14
 * Реализовать очередь (ResizingArrayQueueOfStrings) на основе массива,
 * который динамически изменяет размер при необходимости
 * Input: a b c d e f g
 */
public class B6_ResizingArrayQueue {

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q1 = new ResizingArrayQueueOfStrings();
        q1.enqueue("one");
        q1.enqueue("two");
        q1.enqueue("three");
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.enqueue("four");
        q1.dequeue();
        q1.enqueue("five");
        q1.enqueue("six");
        for (String s : q1) {
            StdOut.print(s + " ");
        }
        StdOut.println();

        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (true) {
            String s = StdIn.readString();
            if (s.equals(END_MARKER)) {
                break;
            }
            queue.enqueue(s);
        }
        StdOut.println("Итератор: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println("\nМетод dequeue: ");
        while (!queue.isEmpty()) {
            StdOut.print(queue.dequeue() + " ");
        }
    }
}

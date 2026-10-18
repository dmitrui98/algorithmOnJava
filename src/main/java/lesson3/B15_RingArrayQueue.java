package lesson3;

import common.data.structure.queue.RingArrayQueue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Упражнение 1.3.39
 * Кольцевой буфер (очередь) фиксированного размера
 */
public class B15_RingArrayQueue {
    public static void main(String[] args) {
        new B15_RingArrayQueue().go();
    }

    private void go() {
        RingArrayQueue<Integer> queue = new RingArrayQueue<>(10);
        Thread read = new Thread(new RingReadTask(queue));
        Thread write = new Thread(new RingWriteTask(queue));
        write.start();
        read.start();
    }

    private class RingWriteTask implements Runnable {
        private RingArrayQueue<Integer> queue;

        public RingWriteTask(RingArrayQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                while (!queue.isFull()) {
                    queue.enqueue(i++ % 10);
                }
                StdOut.println("Write task: queue is full");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private class RingReadTask implements Runnable {
        private RingArrayQueue<Integer> queue;

        public RingReadTask(RingArrayQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                while (!queue.isEmpty()) {
                    System.out.print(queue.dequeue() + " ");
                }
                StdOut.println("Read task: queue is empty");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

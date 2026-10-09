package lesson3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import util.ArrayUtil;

/**
 * Листинг 1.3.2
 */
public class A01_ReadInts {
    public static void main(String[] args) {
        int[] a = readInts("tinyT.txt");
        ArrayUtil.printArray(a);
    }

    public static int[] readInts(String name) {
        In file = new In(name);
        Queue<Integer> queue = new Queue<>();
        while (!file.isEmpty()) {
            queue.enqueue(file.readInt());
        }
        int[] a = new int[queue.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = queue.dequeue();
        }
        return a;
    }
}

package lesson2;

import edu.princeton.cs.algs4.In;
import util.ArrayUtil;

/**
 * Упражнение 1.2.15
 */
public class C9_FileInput {

    public static void main(String[] args) {
        In file = new In("input.txt");
        int[] a = readInts(file);
        ArrayUtil.printArray(a);
    }

    public static int[] readInts(In file) {
        String s = file.readAll();
        String[] lines = s.split("\\s+");
        int[] a = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            a[i] = Integer.parseInt(lines[i]);
        }
        return a;
    }
}

package lesson3;

import common.data.structure.list.CustomLinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

/**
 * Упражнение 1.3.40
 */
public class B16_MoveToFront {
    public static void main(String[] args) {
        CustomLinkedList<Character> list = new CustomLinkedList<>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            list.removeAll(c);
            list.addFirst(c);
        }
        ArrayUtil.print(list);
    }
}

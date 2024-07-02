package lesson3;

import common.data.structure.stack.FixedCapacityStackOfStrings;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.END_MARKER;

/**
 * Рисунок 1.3.6
 * to be or not to - be - - that - - - is
 * Result: to be not that or be; stack size: 2
 */
public class A3_FixedCapacityStackOfStrings {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        while (true) {
            String item = StdIn.readString();
            if (END_MARKER.equals(item)) {
                break;
            }
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
            if (s.isFull()) {
                StdOut.printf("Стэк польностью заполнен: %s элементов", s.size());
            }
        }
        StdOut.println("(в стеке осталось " + s.size() + ")");
    }
}

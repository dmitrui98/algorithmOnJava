package lesson3;

import common.data.structure.stack.FixedCapacityStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Рис. 1.3.7
 * to be or not to - be - - that - - - is
 */
public class A03_FixedCapacityStack {
    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                if (!stack.isEmpty()) {
                    StdOut.print(stack.pop() + " ");
                }
            } else {
                stack.push(item);
            }
        }
        StdOut.println("В стеке осталось " + stack.size() + " элементов.");
    }
}

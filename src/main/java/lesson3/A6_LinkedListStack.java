package lesson3;

import common.data.structure.stack.LinkedListStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.END_MARKER;

/**
 * Листинг 1.3.6. Алгоритм 1.2
 * Стэк. Реализация на основе связного списка
 *
 * to be or not to - be - - that - - - is
 * Result: to be not that or be; stack size: 2
 */
public class A6_LinkedListStack {

    public static void main(String[] args) {
        LinkedListStack<String> s = new LinkedListStack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String item = StdIn.readString();
            if (END_MARKER.equals(item)) {
                break;
            }
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                sb.append(s.pop()).append(" ");
            }
            StdOut.printf("Current capacity (%s): stackSize: %s\n", ++i, s.size());
        }
        StdOut.print(sb.toString());
        StdOut.println("(в стеке осталось " + s.size() + ")");
        for (String s1 : s) {
            StdOut.println("Элемент стэка: " + s1);
        }
    }
}

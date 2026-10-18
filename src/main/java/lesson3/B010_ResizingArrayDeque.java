package lesson3;

import common.data.structure.deque.ResizingArrayDeque;
import common.data.structure.util.base.Deque;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import static edu.princeton.cs.algs4.StdOut.*;

/**
 * Упражнение 1.3.33
 */
public class B010_ResizingArrayDeque {
    public static void main(String[] args) {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        pushElements(deque);
        println("Size: " + deque.size());
        ArrayUtil.print(deque); // 3 2 1 10 20
        // 3 20 2 1 10 isEmpty true
        print(deque.popLeft() + " ");
        print(deque.popRight() + " ");
        print(deque.popLeft() + " ");
        print(deque.popLeft() + " ");
        print(deque.popLeft() + " ");
        println("isEmpty: " + deque.isEmpty());

        pushElements(deque);
        ArrayUtil.print(deque); // 3 2 1 10 20
        // 20 3 10 1 2 isEmpty true
        print(deque.popRight() + " ");
        print(deque.popLeft() + " ");
        print(deque.popRight() + " ");
        print(deque.popRight() + " ");
        print(deque.popRight() + " ");
        println("isEmpty: " + deque.isEmpty());

        checkResize();
    }

    private static void checkResize() {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
        deque.pushLeft("1");
        deque.pushLeft("2");
        deque.pushLeft("3");
        deque.pushLeft("4");
        deque.pushLeft("5");
        deque.pushLeft("6");
        deque.pushLeft("7");
        deque.pushLeft("8");
        deque.pushLeft("9");
        deque.pushLeft("10");
        println("Array size: " + deque.arraySize());
        deque.pushLeft("11");
        println("Array size: " + deque.arraySize());

        deque = new ResizingArrayDeque<>();
        deque.pushLeft("1");
        deque.pushLeft("1");
        deque.pushLeft("1");
        deque.popLeft();
        println("Array size: " + deque.arraySize());
    }

    private static void pushElements(Deque<String> deque) {
        deque.pushLeft("1");
        deque.pushLeft("2");
        deque.pushRight("10");
        deque.pushLeft("3");
        deque.pushRight("20");
    }
}

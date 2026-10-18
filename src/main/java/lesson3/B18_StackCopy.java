package lesson3;

import common.data.structure.stack.LinkedListStack;
import common.data.structure.util.base.StackInterface;
import util.ArrayUtil;

/**
 * Упражнение 1.3.42
 */
public class B18_StackCopy {
    public static void main(String[] args) {
        StackInterface<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        StackInterface<Integer> stackCopy = new LinkedListStack<>(stack);
        ArrayUtil.print(stack);
        stackCopy.push(4);
        ArrayUtil.print(stackCopy);
    }
}

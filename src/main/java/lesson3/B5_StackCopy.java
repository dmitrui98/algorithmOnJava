package lesson3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Упражнение 1.3.12.
 * Напишите клиент класса Stack с возможностью итерации и статическим методом copy(),
 * который принимает в качестве аргумента стек строк и возвращает копию этого стека
 */
public class B5_StackCopy {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.toString();
        printStack(stack, "stack");

        Stack<String> stackCopy = copy(stack);
        printStack(stackCopy, "stackCopy");
    }

    private static Stack<String> copy(Stack<String> stack) {
        Stack<String> stackCopy1 = new Stack<>();
        Stack<String> stackCopy = new Stack<>();
        for (String s : stack) {
            stackCopy1.push(s);
        }
        for (String s : stackCopy1) {
            stackCopy.push(s);
        }
        return stackCopy;
    }

    private static <T> void printStack(Stack<T> stack, String name) {
        StdOut.printf("Итерация стэка %s:\n", name);
        for (T s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}

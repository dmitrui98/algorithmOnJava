package lesson3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Упражение 1.3.12
 * Напишите клиент класса Stack с возможностью итерации и статическим методом copy(),
 * который принимает в качестве аргумента стек строк и возврпащает копию этого стека
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

        Stack<String> stackCopy = new Stack<>();
        for (String s : stack) {
            stackCopy.push(s);
        }
        printStack(stackCopy, "stackCopy");
    }

    private static <T> void printStack(Stack<T> stack, String name) {
        StdOut.printf("Итерация стэка %s:\n", name);
        for (T s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}

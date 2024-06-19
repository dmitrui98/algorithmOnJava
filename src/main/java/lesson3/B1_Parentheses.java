package lesson3;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.*;

/**
 * Упражнение 1.3.4
 * Правильность растановки скобок
 * [()]{}{[()()]()} - true
 * [(]) - false
 */
public class B1_Parentheses {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        StdOut.println("Введите последовательность скобок:");
        String s = StdIn.readLine();

        boolean isCorrect = true;
        for (int i = 0; i < s.length(); i++) {
            if (!isCorrect) {
                break;
            }
            char c = s.charAt(i);
            switch (c) {
                case LEFT_PAREN:
                case LEFT_BRACKET:
                case LEFT_BRACE:
                    stack.push(c);
                    break;
                case RIGHT_PAREN:
                    isCorrect = checkClosedBracket(stack, LEFT_PAREN);
                    break;
                case RIGHT_BRACKET:
                    isCorrect = checkClosedBracket(stack, LEFT_BRACKET);
                    break;
                case RIGHT_BRACE:
                    isCorrect = checkClosedBracket(stack, LEFT_BRACE);
                    break;
                default:
                    throw new IllegalArgumentException("Symbol not supported");
            }
        }
        if (!stack.isEmpty()) {
            isCorrect = false;
        }
        StdOut.printf("Правильность расстановки скобок: %s\n", isCorrect);
    }

    private static boolean checkClosedBracket(
        Stack<Character> stack,
        char expectedFromStack
    ) {
        if (stack.isEmpty()) {
            return false;
        } else {
            Character element = stack.pop();
            return expectedFromStack == element;
        }
    }
}

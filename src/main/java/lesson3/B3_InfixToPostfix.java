package lesson3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.OPERATORS;

/**
 * Упражнение 1.3.10.
 * Преобразование арифметического выражения из инфиксного вида в постфиксный
 * Input: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * Output: 2 3 4 + 5 6 * * +
 *
 * Input: ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
 * Output: 5 7 1 1 + * + 3 * 2 1 1 + * +
 */
public class B3_InfixToPostfix {

    public static void main(String[] args) {
        StdOut.println("Введите выражение: ");
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (OPERATORS.contains(s)) {
                stack.push(s);
            } else if (s.equals(")")) {
                StdOut.print(stack.pop() + " ");
            } else if (!s.equals("(")) {
                StdOut.print(s + " ");
            }
        }
    }
}

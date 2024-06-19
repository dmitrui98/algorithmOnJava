package lesson3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.END_MARKER;
import static util.BaseConstants.OPERANDS;

/**
 * Упражнение 1.3.9.
 * Напишите программу, которая принимает выражение без левых скобок и
 * выводит эквивалентное инфиксное выражение со вставленными недостающими скобками
 * Input:
 *  1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * Output:
 *  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class B2_AddLeftParentheses {

    public static final String LEFT_PAREN = "(";
    public static final String RIGHT_PAREN = ")";
    public static final String MULTIPLY = "*";
    public static final String MINUS = "-";
    public static final String PLUS = "+";

    public static void main(String[] args) {
        StdOut.println("Введите выражение: ");
        Stack<String> operands = new Stack<>();
        Stack<String> values = new Stack<>();
        while (true) {
            String s = StdIn.readString();
            if (s.equals(END_MARKER)) {
                break;
            }
            if (OPERANDS.contains(s)) {
                operands.push(s);
            } else if (s.equals(RIGHT_PAREN)) {
                String secondValue = values.pop();
                String firstValue = values.pop();
                values.push(
                    LEFT_PAREN + " " +
                        firstValue + " " +
                        operands.pop() + " " +
                        secondValue + " " +
                        RIGHT_PAREN
                );
            } else {
                values.push(s);
            }
        }
        for (String value : values) {
            StdOut.print(value + " ");
        }
    }
}

package lesson3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static util.BaseConstants.*;

/**
 * Напишите программу, которая принимает из стандартного ввода постфиксное выражение,
 * вычисляет его и выводит результат
 * Input: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )   2 3 4 + 5 6 * * +
 * Output: 212
 */
public class B4_EvaluatePostfix {

    public static void main(String[] args) {
        StdOut.println("Введите выражение: ");
        Stack<Double> stack = new Stack<>();
        while (true) {
            String s = StdIn.readString();
            if (s.equals(END_MARKER)) {
                break;
            }
            if (OPERANDS.contains(s)) {
                double first = stack.pop();
                double second = stack.pop();
                switch (s) {
                    case PLUS -> stack.push(first + second);
                    case MULTIPLY -> stack.push(first * second);
//                    case MINUS:
//                        stack.push(first - second);
//                        break;
//                    case DIVIDE:
//                        stack.push(first / second);
//                        break;
                    default -> throw new UnsupportedOperationException("operand not supported");
                }
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        StdOut.println(stack.pop());
    }
}

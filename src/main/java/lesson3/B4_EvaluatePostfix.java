package lesson3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.BaseConstants;

import static util.BaseConstants.*;

/**
 * Упражнение 1.3.11.
 * Напишите программу, которая принимает из стандартного ввода постфиксное выражение,
 * вычисляет его и выводит результат
 * 3 4 5 + *
 * 27
 * 1 2 3 4 5 * + 6 * * +
 * 277
 * 7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 * 30001
 * 7 16 * 5 + 16 * 3 + 16 * 1 +
 * 30001
 *  Input: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )   2 3 4 + 5 6 * * +
 *  Output: 212
 */
public class B4_EvaluatePostfix {

    public static void main(String[] args) {
        StdOut.println("Введите постфиксное выражение через пробел:");
        Stack<Integer> values = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (BaseConstants.OPERATORS.contains(s)) {
                Integer second = values.pop();
                Integer first = values.pop();
                values.push(evaluate(first, second, s));
            } else {
                values.push(Integer.parseInt(s));
            }
        }
        StdOut.println(values.pop());
    }

    private static Integer evaluate(Integer first, Integer second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Operator not supported");
        };
    }
}

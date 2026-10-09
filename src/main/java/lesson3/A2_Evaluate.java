package lesson3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * Листинг 1.3.4
 * Двухстековый алгоритм Дейкстры для вычисления выражения
 *
 * 101.0
 * ( ( 1 + sqrt ( 16.0 ) ) / 2.0 )
 * 2.5
 * ( 1 + ( ( 6 - 3 ) * ( 4 * 5 ) ) )
 * 61.0
 */
public class A2_Evaluate {

    public static void main(String[] args) {
        StdOut.println("Введите выражение:");
        Stack<Double> values = new Stack<>();
        Stack<Operator> operators = new Stack<>();
        String s;
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            Operator operator = Operator.getEnum(s);
            switch (operator) {
                case OPEN_BRACKET:
                    // do nothing
                    break;
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                case SQRT:
                    operators.push(operator);
                    break;
                case CLOSE_BRACKET:
                    values.push(calculate(values, operators.pop()));
                    break;
                default:
                    values.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.println("Result: " + values.pop());
    }

    private static double calculate(Stack<Double> values, Operator operand) {
        double v = values.pop();
        switch (operand) {
            case PLUS -> v = values.pop() + v;
            case MINUS -> v = values.pop() - v;
            case MULTIPLY -> v = values.pop() * v;
            case DIVIDE -> v = values.pop() / v;
            case SQRT -> v = Math.sqrt(v);
        }
        return v;
    }

    enum Operator {
        DEFAULT(""),
        OPEN_BRACKET("("),
        CLOSE_BRACKET(")"),
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        SQRT("sqrt"),
        ;
        final String value;

        Operator(String value) {
            this.value = value;
        }

        static Operator getEnum(String value) {
            return Stream.of(Operator.values())
                .filter((it) -> it.value.equals(value))
                .findFirst()
                .orElse(DEFAULT);
        }
    }
}

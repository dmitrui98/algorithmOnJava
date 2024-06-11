package lesson3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * Двухстековый алгоритм Дейкстры для вычисления выражения
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * 101.0
 * ( ( 1 + sqrt ( 5.0 ) ) / 2.0 )
 * 1.618033...
 */
public class A2_Evaluate {

    public static void main(String[] args) {
        StdOut.println("Введите выражение:");
        Stack<Double> values = new Stack<>();
        Stack<Operand> operands = new Stack<>();
        String s;
        while (true) {
            s = StdIn.readString();
            if (s.equals("[")) {
                break;
            }
            Operand operand = Operand.getEnum(s);
            switch (operand) {
                case OPEN_BRACKET:
                    // do nothing
                    break;
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                case SQRT:
                    operands.push(operand);
                    break;
                case CLOSE_BRACKET:
                    values.push(calculate(values, operands.pop()));
                    break;
                default:
                    values.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.println("Result: " + values.pop());
    }

    private static double calculate(Stack<Double> values, Operand operand) {
        double v = values.pop();
        switch (operand) {
            case PLUS -> v = v + values.pop();
            case MINUS -> v = v - values.pop();
            case MULTIPLY -> v = v * values.pop();
            case DIVIDE -> v = v / values.pop();
            case SQRT -> v = Math.sqrt(v);
        }
        return v;
    }

    enum Operand {
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

        Operand(String value) {
            this.value = value;
        }

        static Operand getEnum(String value) {
            return Stream.of(Operand.values())
                .filter((it) -> it.value.equals(value))
                .findFirst()
                .orElse(DEFAULT);
        }
    }
}

package util;

import java.util.Set;

public class BaseConstants {
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String MINUS = "-";
    public static final String PLUS = "+";
    public static final Set<String> OPERANDS = Set.of(MINUS, PLUS, DIVIDE, MULTIPLY);

    public static final char LEFT_PAREN = '(';
    public static final char RIGHT_PAREN = ')';
    public static final char LEFT_BRACKET = '[';
    public static final char LEFT_BRACE = '{';
    public static final char RIGHT_BRACKET = ']';
    public static final char RIGHT_BRACE = '}';

    public static final String END_MARKER = "!q";
}

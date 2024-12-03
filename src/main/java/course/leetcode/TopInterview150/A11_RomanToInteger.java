package course.leetcode.TopInterview150;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class A11_RomanToInteger {

    public static void main(String[] args) {
        new A11_RomanToInteger().go();
    }

    private void go() {
        String s;
        int result;

        s = "III";
        result = romanToInt(s);
        assert result == 3;

        s = "LVIII";
        result = romanToInt(s);
        assert result == 58;
        // Explanation: L = 50, V= 5, III = 3.

        s = "MCMXCIV";
        result = romanToInt(s);
        assert result == 1994;
        // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    }

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length() - 1) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (isNeedSubtract(current, next)) {
                result += convertRoman(next) - convertRoman(current);
                i++;
            } else {
                result += convertRoman(current);
            }
            i++;
        }
        // handle last element
        if (i < s.length()) {
            result += convertRoman(s.charAt(i));
        }
        return result;
    }

    private boolean isNeedSubtract(char current, char next) {
        if ((next == 'V' || next == 'X') && current == 'I') {
            return true;
        }
        if ((next == 'L' || next == 'C') && current == 'X') {
            return true;
        }
        return (next == 'D' || next == 'M') && current == 'C';
    }

    private int convertRoman(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}

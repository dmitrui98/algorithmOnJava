package lesson1;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1.1.18
 */
public class A18_MysteryMathOperationsTask {

    /**
     * Как понять, почему результатом рекурсии является результат умножения или возведение в степень??
     */
    public static void main(String[] args) {
        println(magicDegree(2, 20));
        println(magicMultiply(2, 25));
        println("multiply 3, 11: " + magicMultiply(3, 11));
    }

    private static int magicDegree(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return magicDegree(a * a, b / 2);
        }
        return magicDegree(a * a, b / 2) * a;
    }

    private static int magicMultiply(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return magicMultiply(a + a, b / 2);
        }
        return magicMultiply(a + a, b / 2) + a;
    }
}

package lesson1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.6
 * Что выведет данный код?
 * Ответ: первые 16 чисел последовательности Фибоначчи
 */
public class A6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}

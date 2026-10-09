package lesson1;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1.1.3
 */
public class A3 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if (a == b && a == c) {
            println("равны");
        } else {
            println("не равны");
        }
    }
}

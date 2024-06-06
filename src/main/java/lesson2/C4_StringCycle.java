package lesson2;

import edu.princeton.cs.algs4.*;
import util.Pair;

import java.awt.*;

/**
 * 1.2.6
 * A string s is a circular rotation of a string t if it matches when the characters are circularly
 * shifted by any number of positions; e.g.,
 * ACTGACG is a circular shift of TGACGAC, and vice versa.
 * Detecting this condition is important in the study of genomic sequences.
 * Write a program that checks whether two given strings s and t are circular shifts of one another.
 */
public class C4_StringCycle {
    public static void main(String[] args) {
        StdOut.print("Введите первую строку: ");
        String s = StdIn.readLine();
        StdOut.print("Введите вторую строку: ");
        String t = StdIn.readLine();
        boolean isCycle = false;

        String answer;
        if (isCycle) {
            answer = "является";
        } else {
            answer = "не является";
        }
        StdOut.printf("Строка s ('%s') %s циклическим вращением строки t ('%s')", s, answer, t);
    }
}

package lesson1;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

import static edu.princeton.cs.algs4.StdOut.printf;

public class PrintFormatTask {

    /*
        Input:
        vovan 44 22
        petya 50 33
        katya 8 3
        Golikov_Dmitriy 10 5
        eche 55 8
     */
    public static void main(String[] args) {
        String s = "undefined";
        List<String> lines = new ArrayList<>();
        while (!s.isBlank()) {
            s = StdIn.readLine();
            if (!s.isBlank()) {
                lines.add(s);
            }
        }
        String[] lineData;
        printf("%-20s %-10s %-10s %-10s\n", "name", "first", "second", "division");
        for (String line : lines) {
            lineData = line.split(" ");
            String name = lineData[0];
            int first = Integer.parseInt(lineData[1]);
            int second = Integer.parseInt(lineData[2]);
            double division = 1.0 * first / second;
            printf("%-20s %-10d %-10d %-10.3f\n", name, first, second, division);
        }
    }
}

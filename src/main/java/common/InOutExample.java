package common;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.println;

public class InOutExample {

    public static void main(String[] args) {
        println("Число введите: ");
        int input = StdIn.readInt();
        println(input);
        Out file = new Out("out.txt");
        file.println(10);
        file.println(20);
        file.println(30);
        In inFile = new In("in.txt");
        String[] lines = inFile.readAllLines();
        for (String line : lines) {
            println(line);
        }

        println("absolute: ");
        In inFile1 = new In("C:\\Users\\User\\IdeaProjects\\testic1\\src\\main\\java\\testic.txt");
        lines = inFile1.readAllLines();
        for (String line : lines) {
            println(line);
        }
    }
}

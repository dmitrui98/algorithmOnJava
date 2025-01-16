package common;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;
import static edu.princeton.cs.algs4.StdOut.println;

public class InOutExample {

    public static void main(String[] args) {
        println("Sample of input/output operations");
        println("Число введите: ");
        int input = StdIn.readInt();
        println(input);
        Out file = new Out("data/sample_out.txt");
        file.println(10);
        file.println(20);
        file.println(30);
        In inFile = new In("data/sample_in.txt");
        String[] lines = inFile.readAllLines();
        for (String line : lines) {
            println(line);
        }

        try {
            println("absolute: ");
            In inFile1 = new In("C:\\Users\\User\\IdeaProjects\\testic1\\src\\main\\java\\testic.txt");
            lines = inFile1.readAllLines();
            for (String line : lines) {
                println(line);
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

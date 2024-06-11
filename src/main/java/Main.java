import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Vector;

import java.util.ArrayList;
import java.util.List;

import static edu.princeton.cs.algs4.StdOut.*;

public class Main {

    public static void main(String[] args) {
        // 1.2.6 - to be continued

        String s = reverse("second1");
        StdOut.print(s);
    }

    public static String reverse(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String a = s.substring(0, n/2);
        String b = s.substring(n/2, n);
        return reverse(b) + reverse(a);
    }
}

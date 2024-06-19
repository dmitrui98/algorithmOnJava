import common.data.structure.ResizingArrayStack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // 1.3.12 - to be continued



        ResizingArrayStack<String>[] a = new ResizingArrayStack[10];
        a[0] = new ResizingArrayStack<>(15);
        for (ResizingArrayStack<String> strings : a) {

        }
        String s = reverse("second1");
        StdOut.print(s);
        Stack<String> stack = new Stack<>();

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

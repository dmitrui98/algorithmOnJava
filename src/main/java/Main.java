import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
        // 1.3.30 - to be continued
        StdOut.println(mystery("Hello World"));
    }

    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String a = s.substring(0, n / 2);
        String b= s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }
}

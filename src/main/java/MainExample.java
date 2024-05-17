import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.printf;

public class MainExample {

    public static void main(String[] args) {
        int a = StdRandom.uniformInt(100);
        System.out.println(a);

        printf("ПИ примерно равно %.4f\n", Math.PI);
        printf("Пример отступа: %14d вот такой\n", 88);
        printf("Пример отступа: %-14d вот такой\n", 88);
    }
}

package course.ulbiTV;

public class A5_1_Recursion {
    private static int count = 0;
    private static int countFib = 0;

    public static void main(String[] args) {
        A5_1_Recursion recursion = new A5_1_Recursion();
        int n = 8;
        long factorialResult = recursion.factorial(n);
        System.out.printf("factorialResult(%s): %s; depth: %s\n", n, factorialResult, count);

        n = 8;
        long fibonachiResult = recursion.fibonachi(n);
        System.out.printf("fibonachiResult(%s): %s; depth: %s\n", n, fibonachiResult, countFib);
    }

    private long factorial(long n) {
        count++;
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Числа фибоначчи: 1,1,2,3,5,8,13,21
     * @param n номер числа в цепочке
     */
    private long fibonachi(long n) {
        countFib++;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonachi(n - 1) + fibonachi(n - 2);
    }
}

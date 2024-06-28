package lesson2;

import edu.princeton.cs.algs4.StdOut;
import lesson1.Euclid;

/**
 * Операции над рациональными числами
 */
public class C8_Rational implements Comparable<C8_Rational> {
    private final long numerator;
    private final long denominator;

    public C8_Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public C8_Rational plus(C8_Rational b) {
        return new C8_Rational(
            numerator * b.denominator + b.numerator * denominator,
            denominator * b.denominator
        );
    }

    public C8_Rational minus(C8_Rational b) {
        return new C8_Rational(
            numerator * b.denominator - b.numerator * denominator,
            denominator * b.denominator
        );
    }

    public C8_Rational multiply(C8_Rational b) {
        return new C8_Rational(
            numerator * b.numerator,
            denominator * b.denominator
        );
    }

    public C8_Rational divide(C8_Rational b) {
        return new C8_Rational(
            numerator * b.denominator,
            denominator * b.numerator
        );
    }

    /**
     * Also can be implemented via simplify and compare numerator and denominator
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        C8_Rational other = ((C8_Rational) obj).simplify();
        return simplify().compareTo(other) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }

    @Override
    public int compareTo(C8_Rational o) {
        long current = numerator * o.denominator;
        long other = denominator * o.numerator;
        if (current < other) return -1;
        if (current > other) return 1;
        return 0;
    }

    private C8_Rational simplify() {
        long gcd = Euclid.greatestCommonDivider(numerator, denominator);
        return new C8_Rational(numerator / gcd, denominator / gcd);
    }

    public static void main(String[] args) {
        C8_Rational r1 = new C8_Rational(5, 10);
        C8_Rational r2 = new C8_Rational(50, 100);
        C8_Rational r3 = new C8_Rational(50, 101);
        StdOut.printf("%s; %s equals: %s\n", r1, r2, r1.equals(r2));
        StdOut.printf("%s; %s equals: %s\n", r2, r3, r2.equals(r3));

        C8_Rational r4 = new C8_Rational(7, 9);
        StdOut.printf("%s; %s multiply: %s\n", r1, r4, r1.multiply(r4));
        StdOut.printf("%s; %s multiply simplified: %s\n", r1, r4, r1.multiply(r4).simplify());

        StdOut.printf("%s; %s divide: %s\n", r1, r4, r1.divide(r4));

        StdOut.printf("%s; %s plus: %s\n", r1, r4, r1.plus(r4));
        StdOut.printf("%s; %s minus: %s\n", r1, r4, r1.minus(r4));
    }
}

package lesson2;

import edu.princeton.cs.algs4.Date;

public class C7_Transaction {
    private final String who;
    private final Date transactonDate;
    private final double amount;

    public C7_Transaction(String who, Date transactonDate, double amount) {
        this.who = who;
        this.transactonDate = transactonDate;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        C7_Transaction that = (C7_Transaction) obj;
        return who.equals(that.who)
                && transactonDate.equals(that.transactonDate)
                && amount == that.amount;
    }
}

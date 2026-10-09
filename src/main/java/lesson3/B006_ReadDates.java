package lesson3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;
import util.BaseConstants;

/**
 * Упражнение 1.3.16, 1.3.17
 * Input
 * 5/22/1939 6/21/2022 12/01/2026
 * Dima 6/21/2022 5.5
 * Kostya 12/18/2026 54.5
 * Petya 1/22/2025 107.9
 */
public class B006_ReadDates {
    public static void main(String[] args) {
        StdOut.println("Введите даты:");
        Date[] dates = readDates();
        for (Date date : dates) {
            StdOut.print(date + " ");
        }
        StdOut.println();

        StdOut.println("Введите транзакции (who, date, amount):");
        Transaction[] transactions = readTransactions();
        for (Transaction transaction : transactions) {
            StdOut.println(transaction);
        }
    }

    public static Date[] readDates() {
        Queue<Date> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals(BaseConstants.END_MARKER)) {
                break;
            }
            Date date = getDate(s);
            queue.enqueue(date);
        }
        Date[] a = new Date[queue.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = queue.dequeue();
        }
        return a;
    }

    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            if (s.isEmpty()) {
                continue;
            }
            if (s.equals(BaseConstants.END_MARKER)) {
                break;
            }
            Transaction transaction = getTransaction(s);
            queue.enqueue(transaction);
        }
        Transaction[] a = new Transaction[queue.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = queue.dequeue();
        }
        return a;
    }

    private static Transaction getTransaction(String s) {
        String[] transactionString = s.split(" ");
        Transaction transaction = new Transaction(
            transactionString[0],
            getDate(transactionString[1]),
            Double.parseDouble(transactionString[2])
        );
        return transaction;
    }

    private static Date getDate(String dateString) {
        String[] s = dateString.split("/");
        Date date = new Date(
            Integer.parseInt(s[0]),
            Integer.parseInt(s[1]),
            Integer.parseInt(s[2])
        );
        return date;
    }
}

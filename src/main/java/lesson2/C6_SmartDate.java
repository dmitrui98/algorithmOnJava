package lesson2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Implementation of the method dayOfTheWeek (XXI)
 */
public class C6_SmartDate extends Date {
    private final String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
    public C6_SmartDate(int month, int day, int year) {
        super(month, day, year);
    }

    public C6_SmartDate(String date) {
        super(date);
    }

    public String dayOfTheWeek() {
        LocalDate a = LocalDate.of(year(), month(), day());
        StdOut.println(a.getDayOfWeek());
        return days[a.getDayOfWeek().getValue() - 1];
    }

    /**
     * Invalid code!!!
     */
    public String dayOfTheWeek1() {
        int c = year() / 100;
        int y = year() % 100;
        int m = month();
        if (m < 3) {
            m = m + 10;
            y = y + 1;
        } else {
            m = m - 2;
        }
        double w = Math.abs((2.6 * m - 0.2) + day() + y / 4 + y + c / 4 - 2 * c) % 7;
        return days[(int) w];
    }

    public static void main(String[] args) {
        C6_SmartDate date = new C6_SmartDate("02/29/2024");
        String day = date.dayOfTheWeek();
        StdOut.print(day);
    }
}

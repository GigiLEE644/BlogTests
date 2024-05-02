import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Java8NewFeaturesTest92 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        System.out.println(now);

        LocalDate future = LocalDate.of(2025, 02, 23);

        System.out.println(future);

        LocalDate past = LocalDate.parse("2022-03-17");

        System.out.println(past);

        LocalDate oneDayAfter = now.plusDays(1);

        System.out.println(oneDayAfter);

        LocalDate oneMonthAfter = now.plus(1, ChronoUnit.MONTHS);

        System.out.println(oneMonthAfter);

        int dayOfMonth = now.getDayOfMonth();

        System.out.println(dayOfMonth);

        int dayOfYear = now.getDayOfYear();

        System.out.println(dayOfYear);

        boolean isLeapYear = now.isLeapYear();

        System.out.println(isLeapYear);

        boolean isBefore = now.isBefore(future);

        System.out.println(isBefore);

        boolean isAfter = now.isAfter(past);

        System.out.println(isAfter);
    }
}

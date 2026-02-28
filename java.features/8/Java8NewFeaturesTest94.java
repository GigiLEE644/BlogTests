import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Java8NewFeaturesTest94 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDateTime future = LocalDateTime.of(2025, 12, 23, 23, 39, 33);

        System.out.println(future);

        LocalDateTime past = LocalDateTime.parse("2023-01-02T12:23:21");

        System.out.println(past);

        boolean isAfter = now.isAfter(past);

        System.out.println(isAfter);

        boolean isBefore = now.isBefore(future);

        System.out.println(isBefore);

        LocalDateTime plus = now.plus(1, ChronoUnit.DAYS);

        System.out.println(plus);

        LocalDateTime minus = now.minus(1, ChronoUnit.HOURS);

        System.out.println(minus);

        int year = now.getYear();
        int month = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.println(year + "-" + month + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second);
    }
}
/**
 * Output:
        2026-02-28T08:29:25.981021908
        2025-12-23T23:39:33
        2023-01-02T12:23:21
        true
        false
        2026-03-01T08:29:25.981021908
        2026-02-28T07:29:25.981021908
        2026-2-28 8:29:25
 */
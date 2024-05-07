import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Java8NewFeaturesTest97 {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(11, 01, 02);
        LocalTime endTime = LocalTime.of(12, 10, 13);

        Duration d1 = Duration.between(startTime, endTime);

        System.out.println(!d1.isNegative() ? startTime + " is before " + endTime : startTime + " is after " + endTime);
        System.out.println(d1.toHours());
        System.out.println(d1.toMinutes());
        System.out.println(d1.toSeconds());

        System.out.println();

        Duration d2 = Duration.between(endTime, startTime);

        System.out.println(!d2.isNegative() ? endTime + " is before " + startTime : endTime + " is after " + startTime);
        System.out.println(d2.toHours());
        System.out.println(d2.toMinutes());
        System.out.println(d2.toSeconds());

        System.out.println();

        Duration d3 = Duration.parse("PT2H3M4S");
        System.out.println(d3.isNegative());
        System.out.println(d3.toHours());
        System.out.println(d3.toMinutes());
        System.out.println(d3.toSeconds());

        System.out.println();

        startTime = startTime.plus(Duration.ofHours(1));
        startTime = startTime.plus(Duration.ofMinutes(-1));
        startTime = startTime.plus(Duration.ofSeconds(1));

        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);

        Duration d4 = Duration.between(startTime, endTime);

        System.out.println(d4);

        LocalDateTime startDateTime = LocalDateTime.of(2024, 03, 01, 12, 13, 14);
        LocalDateTime endDateTime = LocalDateTime.of(2025, 04, 02, 13, 14, 15);

        Duration d5 = Duration.between(startDateTime, endDateTime);

        System.out.println(d5);
    }
}
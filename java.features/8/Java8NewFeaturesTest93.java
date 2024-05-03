import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Java8NewFeaturesTest93 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();

        System.out.println(now);

        LocalTime past = LocalTime.of(06, 20, 32);

        System.out.println(past);

        LocalTime future = LocalTime.parse("22:27:39");

        System.out.println(future);

        LocalTime plus = now.plus(1, ChronoUnit.HOURS);

        System.out.println(plus);

        LocalTime minus = now.minus(1, ChronoUnit.HOURS);

        System.out.println(minus);

        boolean isBefore = now.isBefore(future);

        System.out.println(isBefore);

        boolean isAfter = now.isAfter(past);

        System.out.println(isAfter);

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.println(hour + ":" + minute + ":" + second);

        System.out.println(LocalTime.MAX);

        System.out.println(LocalTime.MIN);
    }
}

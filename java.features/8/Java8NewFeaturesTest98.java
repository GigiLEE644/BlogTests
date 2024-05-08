import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Java8NewFeaturesTest98 {
    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.of(2024, 8, 31, 10, 20, 55);
        LocalDateTime endDate = LocalDateTime.of(2027, 11, 9, 10, 21, 56);

        System.out.println(startDate);
        System.out.println(endDate);

        long years = ChronoUnit.YEARS.between(startDate, endDate);
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        long weeks = ChronoUnit.WEEKS.between(startDate, endDate);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long hours = ChronoUnit.HOURS.between(startDate, endDate);
        long minutes = ChronoUnit.MINUTES.between(startDate, endDate);
        long seconds = ChronoUnit.SECONDS.between(startDate, endDate);
        long milis = ChronoUnit.MILLIS.between(startDate, endDate);
        long nano = ChronoUnit.NANOS.between(startDate, endDate);

        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");
    }
}
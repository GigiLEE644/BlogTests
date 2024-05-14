import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Java8NewFeaturesTest100 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2015, 10, 03);

        String formatedD = d.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        System.out.println(formatedD);

        LocalTime t = LocalTime.of(11, 20, 58);

        String formatedT = t.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        System.out.println(formatedT);

        LocalDateTime dt = LocalDateTime.of(2016, 04, 03, 01, 30, 9);

        String formatedDT = dt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"));

        System.out.println(formatedDT);
    }
}
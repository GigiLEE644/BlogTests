import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Java8NewFeaturesTest99 {
    public static void main(String[] args) {
        Date d = new Date();

        System.out.println(d);

        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

        System.out.println();

        LocalDateTime ldt1 = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());

        System.out.println(ldt1);

        LocalDateTime ldt2 = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());

        System.out.println(ldt2);
    }
}
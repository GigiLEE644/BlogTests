import java.time.LocalDate;
import java.time.Period;

public class Java8NewFeaturesTest96 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 02, 02);
        LocalDate endDate = LocalDate.of(2025, 01, 03);

        Period p1 = Period.between(startDate, endDate);

        System.out.println(!p1.isNegative() ? startDate + " is before " + endDate : startDate + " is after " + endDate);
        System.out.println(p1.getYears());
        System.out.println(p1.getMonths());
        System.out.println(p1.getDays());

        System.out.println();

        Period p2 = Period.between(endDate, startDate);

        System.out.println(!p2.isNegative() ? endDate + " is before " + startDate : endDate + " is after " + startDate);
        System.out.println(p2.getYears());
        System.out.println(p2.getMonths());
        System.out.println(p2.getDays());

        System.out.println();

        Period p3 = Period.of(2, 3, 4);
        System.out.println(p3.isNegative());
        System.out.println(p3.getYears());
        System.out.println(p3.getMonths());
        System.out.println(p3.getDays());

        System.out.println();

        Period p4 = Period.of(-2, 3, 4);
        System.out.println(p4.isNegative());
        System.out.println(p4.getYears());
        System.out.println(p4.getMonths());
        System.out.println(p4.getDays());

        System.out.println();

        Period p5 = Period.parse("P2Y3M4D");
        System.out.println(p5.isNegative());
        System.out.println(p5.getYears());
        System.out.println(p5.getMonths());
        System.out.println(p5.getDays());

        System.out.println();

        Period p6 = Period.parse("P-2Y3M4D");
        System.out.println(p6.isNegative());
        System.out.println(p6.getYears());
        System.out.println(p6.getMonths());
        System.out.println(p6.getDays());

        System.out.println();

        startDate = startDate.plus(Period.ofYears(1));
        startDate = startDate.plus(Period.ofMonths(-1));
        startDate = startDate.plus(Period.ofDays(1));

        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);

        Period p7 = Period.between(startDate, endDate);

        System.out.println(p7);
    }
}
import java.text.NumberFormat;
import java.util.Locale;

public class Java17NewFeaturesTest23 {
        public static void main(String[] args) {
                int thousand = 1000;
                int million = thousand * thousand;
                int billion = million * thousand;

                System.out.println(thousand);
                System.out.println(million);
                System.out.println(billion);

                System.out.println();

                NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

                System.out.println("Long Formats :");
                format(thousand, million, billion, formatter);

                System.out.println();

                formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

                System.out.println("Short Formats :");
                format(thousand, million, billion, formatter);
        }

        private static void format(int thousand, int million, int billion, NumberFormat formatter) {
                System.out.println(formatter.format(thousand));
                System.out.println(formatter.format(million));
                System.out.println(formatter.format(billion));
        }
}
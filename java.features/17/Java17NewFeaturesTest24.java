import java.text.NumberFormat;
import java.util.Locale;

public class Java17NewFeaturesTest24 {
        public static void main(String[] args) {
                int fraction = 12;

                int thousand = 1000;
                int thousand_with_fraction = thousand + fraction;

                int million = thousand * thousand;
                int million_with_fraction = million + fraction;

                System.out.println(thousand_with_fraction);
                System.out.println(million_with_fraction);

                System.out.println();

                NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

                System.out.println("Without using Fractions :");
                format(thousand_with_fraction, million_with_fraction, formatter);

                System.out.println();

                formatter.setMinimumFractionDigits(2);

                System.out.println("Using Fractions :");

                format(thousand_with_fraction, million_with_fraction, formatter);
        }

        private static void format(int thousand_with_fraction, int million_with_fraction, NumberFormat formatter) {
                System.out.println(formatter.format(thousand_with_fraction));
                System.out.println(formatter.format(million_with_fraction));
        }
}
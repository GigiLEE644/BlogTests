public class Java17NewFeaturesTest4 {

        public static void main(String[] args) {
                System.out.println(getDayOfWeek(1));

                System.out.println(getDayOfWeek(6));

                System.out.println(getDayOfWeek(0));
        }

        private static String getDayOfWeek(int day) {
                String dayOfWeek = switch (day) {
                        case 1, 2, 3, 4, 5 -> "Weekday";
                        case 6, 7 -> "Weekend";
                        default -> "Not a valid day of week !!!";
                };
                return dayOfWeek;
        }
}
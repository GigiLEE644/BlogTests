public class Java17NewFeaturesTest2 {

        public static void main(String[] args) {
                System.out.println(getDayOfWeek(1));

                System.out.println(getDayOfWeek(5));

                System.out.println(getDayOfWeek(0));
        }

        private static String getDayOfWeek(int day) {
                String dayOfWeek = switch (day) {
                        case 1 -> "Monday";
                        case 2 -> "Tuesday";
                        case 3 -> "Wednesday";
                        case 4 -> "Thursday";
                        case 5 -> "Friday";
                        case 6 -> "Saturday";
                        case 7 -> "Sunday";
                        default -> "Not a valid day of week !!!";
                };
                return dayOfWeek;
        }
}
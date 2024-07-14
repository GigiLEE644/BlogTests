public class Java17NewFeaturesTest3 {

        public static void main(String[] args) {
                System.out.println(getDayOfWeek(1));

                System.out.println(getDayOfWeek(5));

                System.out.println(getDayOfWeek(0));
        }

        private static String getDayOfWeek(int day) {
                String dayOfWeek = switch (day) {
                        case 1 -> {
                                System.out.print("day = 1, it is ");
                                yield "Monday";
                        }
                        case 2 -> {
                                System.out.print("day = 2, it is ");
                                yield "Tuesday";
                        }
                        case 3 -> {
                                System.out.print("day = 3, it is ");
                                yield "Wednesday";
                        }
                        case 4 -> {
                                System.out.print("day = 4, it is ");
                                yield "Thursday";
                        }
                        case 5 -> {
                                System.out.print("day = 5, it is ");
                                yield "Friday";
                        }
                        case 6 -> {
                                System.out.print("day = 6, it is ");
                                yield "Saturday";
                        }
                        case 7 -> {
                                System.out.print("day = 7, it is ");
                                yield "Sunday";
                        }
                        default -> "Not a valid day of week !!!";
                };
                return dayOfWeek;
        }
}
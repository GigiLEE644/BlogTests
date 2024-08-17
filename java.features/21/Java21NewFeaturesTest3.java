public class Java21NewFeaturesTest3 {

        public static void main(String[] args) {
                System.out.println("It is a " + what(""));

                System.out.println("It is a " + what("hello world"));

                System.out.println("It is a " + what(100));

                System.out.println("It is a " + what(-100));
        }

        private static String what(Object obj) {
                return switch (obj) {
                        case String s when !s.isEmpty() -> "none empty string";
                        case String s when s.isEmpty() -> "empty string";
                        case Integer i when i >= 0 -> "positive integer";
                        case Integer i when i < 0 -> "negative integer";
                        case null, default -> "oops";
                };
        }
}
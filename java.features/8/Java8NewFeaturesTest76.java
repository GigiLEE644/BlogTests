public class Java8NewFeaturesTest76 {
    public static void main(String[] args) {
        French french = new French();

        System.out.println(french.greeting());
        System.out.println(french.laugh());

        System.out.println();

        English english = new English();

        System.out.println(english.greeting());
        System.out.println(english.laugh());
    }

    private static interface Person {
        default String laugh() {
            return "hahahahaha";
        }

        String greeting();
    }

    private static class French implements Person {
        @Override
        public String greeting() {
            return "bonjour";
        }
    }

    private static class English implements Person {
        @Override
        public String greeting() {
            return "hello";
        }
    }
}

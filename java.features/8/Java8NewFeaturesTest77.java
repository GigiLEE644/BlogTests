public class Java8NewFeaturesTest77 {
    public static void main(String[] args) {
        EnglandBornFrench p1 = new EnglandBornFrench();
        System.out.println(p1.greeting());

        System.out.println();

        FranceBornEnglish p2 = new FranceBornEnglish();
        System.out.println(p2.greeting());
    }

    private static interface French {
        default String greeting() {
            return "bonjour";
        }
    }

    private static interface English {
        default String greeting() {
            return "hello";
        }
    }

    private static class EnglandBornFrench implements French, English {
        @Override
        public String greeting() {
            return English.super.greeting();
        }
    }

    private static class FranceBornEnglish implements French, English {
        @Override
        public String greeting() {
            return French.super.greeting();
        }
    }
}

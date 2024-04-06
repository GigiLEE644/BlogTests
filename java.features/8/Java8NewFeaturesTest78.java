public class Java8NewFeaturesTest78 {
    public static void main(String[] args) {
        System.out.println(Person.laugh());
    }

    private static interface Person {
        static String laugh() {
            return "hahahaha";
        }
    }
}

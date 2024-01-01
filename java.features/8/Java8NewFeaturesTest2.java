public class Java8NewFeaturesTest2 {
    public static void main(String[] args) {
        MyComparator c = (a, b) -> {
            if (a > b) {
                System.out.println(a + " is bigger than " + b);
            } else if (a == b) {
                System.out.println(a + " is equal to " + b);
            } else {
                System.out.println(a + " is smaller than " + b);
            }
        };

        c.compare(1, 2);
    }

    @FunctionalInterface
    private static interface MyComparator {
        void compare(int a, int b);
    }
}

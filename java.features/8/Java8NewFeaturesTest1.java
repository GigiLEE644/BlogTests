public class Java8NewFeaturesTest1 {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;

        compare(new MyComparator() {
            @Override
            public void compare(int a, int b) {
                if (a > b) {
                    System.out.println(a + " is bigger than " + b);
                } else if (a == b) {
                    System.out.println(a + " is equal to " + b);
                } else {
                    System.out.println(a + " is smaller than " + b);
                }
            }
        }, x, y);
    }

    private static void compare(MyComparator c, int x, int y) {
        c.compare(x, y);
    }

    private static interface MyComparator {
        void compare(int a, int b);
    }
}

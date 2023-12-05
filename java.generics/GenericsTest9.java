public class GenericsTest9 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        compare(a, b, new Comparison(a, b));

        double c = 1d;
        double d = 2d;

        compare(c, d, new Comparison(c, d));
    }

    private static <T extends Comparable<T>> void compare(T a, T b, Comparison c) {
        if (c.bigger) {
            System.out.println(a + " is bigger than " + b);
        } else {
            System.out.println(a + " is smaller than " + b);
        }
    }

    private static class Comparison {
        boolean bigger;

        <T extends Comparable<T>> Comparison(T a, T b) {
            if (a.compareTo(b) > 0) {
                this.bigger = true;
            }
        }
    }
}

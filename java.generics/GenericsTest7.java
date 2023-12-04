public class GenericsTest7 {
    public static void main(String[] args) {
        System.out.println("int min = " + min(1, 2));
        System.out.println("int max = " + max(1, 2));

        System.out.println("double min = " + min(1d, 2d));
        System.out.println("double max = " + max(1d, 2d));
    }

    private static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) > 0 ? b : a;
    }

    private static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}

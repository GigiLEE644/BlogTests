public class GenericsTest7 {
    public static void main(String[] args) {
        System.out.println(min(1, 2));
        System.out.println(max(1, 2));
    }

    private static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) > 0 ? b : a;
    }

    private static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}

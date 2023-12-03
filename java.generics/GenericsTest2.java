public class GenericsTest2 {
    public static void main(String[] args) {
        System.out.println(max(1, 2));
        System.out.println(max(1f, 2f));
        System.out.println(max(1d, 2d));
    }

    private static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}
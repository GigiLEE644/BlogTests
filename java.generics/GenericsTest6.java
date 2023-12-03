public class GenericsTest6 {
    public static void main(String[] args) {
        MaxMin<Integer> c1 = new MaxMin<>();

        System.out.println("int min : " + c1.min(1, 2));
        System.out.println("int max : " + c1.max(1, 2));

        MaxMin<Double> c2 = new MaxMin<>();

        System.out.println("double min : " + c2.min(1d, 2d));
        System.out.println("double max : " + c2.max(1d, 2d));
    }

    private static interface MyComparable<T extends Comparable<T>> {
        T max(T a, T b);

        T min(T a, T b);
    }

    private static class MaxMin<T extends Comparable<T>> implements MyComparable<T> {
        @Override
        public T max(T a, T b) {
            return a.compareTo(b) < 0 ? b : a;
        }

        @Override
        public T min(T a, T b) {
            return a.compareTo(b) < 0 ? a : b;
        }
    }
}

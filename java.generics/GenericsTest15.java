public class GenericsTest15 {
    public static void main(String[] args) {
        Integer[] elements = { 1, 2, 3 };

        System.out.println("max : " + max(elements));
        System.out.println("min : " + min(elements));
    }

    private static <T extends Comparable<T>> T max(T[] elements) {
        T max = elements[0];

        for (int i = 0; i < elements.length; i++) {
            T current = elements[i];

            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }

    private static <T extends Comparable<T>> T min(T... elements) {
        T min = elements[0];

        for (int i = 0; i < elements.length; i++) {
            T current = elements[i];

            if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        return min;
    }
}

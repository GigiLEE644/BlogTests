public class GenericsTest8 {
    public static void main(String[] args) {
        Comparison<Integer> c1 = new Comparison<Integer>(1, 2);

        System.out.println(c1.max());

        System.out.println(c1.min());

        Comparison<Double> c2 = new Comparison<Double>(1d, 2d);

        System.out.println(c2.max());

        System.out.println(c2.min());
    }

    private static class Comparison<T extends Comparable<T>> {
        T a;
        T b;

        Comparison(T a, T b) {
            this.a = a;
            this.b = b;
        }

        T max() {
            return this.a.compareTo(this.b) > 0 ? this.a : this.b;
        }

        T min() {
            return this.a.compareTo(this.b) > 0 ? this.b : this.a;
        }
    }
}

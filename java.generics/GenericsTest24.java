public class GenericsTest24 {
    public static void main(String[] args) {
        System.out.println(Func.<Integer>apply(1));
        System.out.println(Func.<Float>apply(1f));
        System.out.println(Func.<Double>apply(1d));

        Func<String> f = new Func<>();
        System.out.println(f.apply(1));
        System.out.println(f.apply(1f));
        System.out.println(f.apply(1d));
    }

    private static class Func<T> {
        static <T> T apply(T value) {
            return value;
        }
    }
}

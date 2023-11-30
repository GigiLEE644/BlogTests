public class GenericsTest2 {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1f, 2f));
        System.out.println(add(1d, 2d));
    }

    private static <T extends Number> double add(T a, T b) {
        double result = a.doubleValue() + b.doubleValue();
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }
}
import java.util.Random;

public class GenericsTest22 {
    public static void main(String[] args) {
        int c1 = choose(1, 2);

        System.out.println(c1);

        Number c2 = choose(1, 2.0);

        System.out.println(c2);

        Object c3 = choose(1, "2");

        System.out.println(c3);

        int c4 = GenericsTest22.<Integer>choose(1, 2);

        System.out.println(c4);

        // The parameterized method <Integer>choose(Integer, Integer) of type GenericsTest22 is not applicable for the arguments (Integer, Double)
        // GenericsTest22.<Integer>choose(1, 2.0);

        Number c5 = GenericsTest22.<Number>choose(1, 2.0);

        System.out.println(c5);

        Object c6 = GenericsTest22.<Object>choose(1, "2");

        System.out.println(c6);
    }

    private static <T> T choose(T a, T b) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high - low) + low;

        if (result <= 50) {
            return a;
        }

        return b;
    }
}

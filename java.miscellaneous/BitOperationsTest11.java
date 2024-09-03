public class BitOperationsTest11 {
    public static void main(String[] args) {
        System.out.println(maximum(10, 11));
        System.out.println(maximum(10, -11));
        System.out.println(maximum(-10, 11));
        System.out.println(maximum(-10, -11));

        System.out.println();

        System.out.println(maximum(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(maximum(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static int maximum(int a, int b) {
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);

        int diff = sa ^ sb;
        int same = flip(diff);

        int sc = sign(c);

        return diff * flip(sa) * a + diff * flip(sb) * b + same * (flip(sc) * a + sc * b);
    }

    private static int sign(int i) {
        return i >>> 31;
    }

    private static int flip(int i) {
        return i ^ 1;
    }
}

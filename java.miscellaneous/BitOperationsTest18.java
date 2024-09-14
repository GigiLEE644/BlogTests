public class BitOperationsTest18 {
    public static void main(String[] args) {
        int a = 5;
        int b = -3;

        int c = neg(b);

        System.out.println("-" + b + " = " + c);

        int d = add(a, b);

        System.out.println(a + " + " + b + " = " + d);

        int e = sub(a, b);

        System.out.println(a + " - " + b + " = " + e);
    }

    private static int add(int a, int b) {
        int aa = a ^ b;
        int bb = (a & b) << 1;

        if (bb == 0) {
            return aa;
        }

        return add(aa, bb);
    }

    private static int sub(int a, int b) {
        return add(a, neg(b));
    }

    private static int neg(int a) {
        return add(~a, 1);
    }
}

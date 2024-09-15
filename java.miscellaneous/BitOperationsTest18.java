public class BitOperationsTest18 {
    public static void main(String[] args) {
        int a = -5;
        int b = 3;

        int d = add(a, b);

        System.out.println(a + " + " + b + " = " + d);

        int e = sub(a, b);

        System.out.println(a + " - " + b + " = " + e);

        int f = mul(a, b);

        System.out.println(a + " * " + b + " = " + f);

        int g = div(a, b);

        System.out.println(a + " / " + b + " = " + g);
    }

    private static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("div by 0");
        }

        int aa = abs(a);
        int bb = abs(b);

        if (aa < bb) {
            return 0;
        }

        int c = 0;

        while (aa >= bb) {
            aa = sub(aa, bb);
            c = add(c, 1);
        }

        if (pos(a) && !pos(b) || !pos(a) && pos(b)) {
            c = neg(c);
        }

        return c;
    }

    private static int abs(int a) {
        if (!pos(a)) {
            return neg(a);
        }

        return a;
    }

    private static int mul(int a, int b) {
        int c = 0;

        if (pos(a) && !pos(b)) {
            for (int i = 0; i < neg(b); i++) {
                c = add(c, a);
            }
            c = neg(c);
        } else if (!pos(a) && pos(b)) {
            for (int i = 0; i < neg(a); i++) {
                c = add(c, b);
            }
            c = neg(c);
        } else if (!pos(a) && !pos(b)) {
            for (int i = 0; i < neg(a); i++) {
                c = add(c, neg(b));
            }
        } else {
            for (int i = 0; i < a; i++) {
                c = add(c, b);
            }
        }

        return c;
    }

    private static boolean pos(int a) {
        int mask = 1 << 31;

        return (a & mask) == 0;
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
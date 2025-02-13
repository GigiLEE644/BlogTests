public class BitOperationsTest20 {
    public static void main(String[] args) {
        int a = 11;

        System.out.println(a);

        for (int i = 31; i >= 0; i--) {
            if (isSet(a, i)) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }

        System.out.println();

        int b = setBit(a, 2);

        System.out.println(b);

        int c = unsetBit(b, 2);

        System.out.println(c);
    }

    // to check if the given bit position in x is set (1).
    private static boolean isSet(int x, int pos) {
        int bit = x & (1 << pos);

        if (bit == 0) {
            return false;
        }

        return true;
    }

    // to set the given bit position in x to 1.
    private static int setBit(int x, int pos) {
        return x |= (1 << pos);
    }

    // to unset the given bit position in x (set it to 0).
    private static int unsetBit(int x, int pos) {
        return x &= ~(1 << pos);
    }
}
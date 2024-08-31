public class BitOperationsTest6 {
    public static void main(String[] args) {
        long a = 9L;

        printBinary(a);

        long b = -9L;

        printBinary(b);

        long c = 0b0000000000000000000000000000000000000000000000000000000000001001L;

        printBinary(c);

        long d = 0b1111111111111111111111111111111111111111111111111111111111110111L;

        printBinary(d);
    }

    private static void printBinary(long num) {
        for (int i = 63; i >= 0; i--) {
            long mask = 1L << i;
            if ((num & mask) == 0L) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        System.out.println();
    }
}

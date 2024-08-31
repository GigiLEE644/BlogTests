public class BitOperationsTest5 {
    public static void main(String[] args) {
        int a = 9;

        printBinary(a);

        int b = -9;

        printBinary(b);

        int c = 0b00000000000000000000000000001001;

        printBinary(c);

        int d = 0b11111111111111111111111111110111;

        printBinary(d);
    }

    private static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((num & mask) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        System.out.println();
    }
}

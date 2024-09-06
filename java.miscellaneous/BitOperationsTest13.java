public class BitOperationsTest13 {
    public static void main(String[] args) {
        int a = 0b00000000000000000111000000001000;

        int aa = oneAtTheMostRightSide(a);

        printBinary(aa);
    }

    private static int oneAtTheMostRightSide(int a) {
        int aa = ~a + 1;

        int aaa = a & (aa);

        return aaa;
    }

    private static void printBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            int mask = (1 << i);

            if ((n & mask) == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }

        System.out.println();
    }
}

public class BitOperationsTest15 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5 };

        display(arr);

        int m = 3;

        int[] bits = new int[32];

        for (int i = 0; i < arr.length; i++) {
            accumulateOneForEveryBit(bits, arr[i]);
        }

        int n = appearsLessThan(bits, m);

        System.out.println("The only number appears less than " + m + " times in above array is : " + n);
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println();
    }

    private static int appearsLessThan(int[] bits, int m) {
        int n = 0;

        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % m != 0) {
                int mask = (1 << i);

                n |= mask;
            }
        }

        return n;
    }

    private static void accumulateOneForEveryBit(int[] bits, int a) {
        for (int i = 0; i < bits.length; i++) {
            int mask = (1 << i);

            if ((a & mask) != 0) {
                bits[i] += 1;
            }
        }
    }
}

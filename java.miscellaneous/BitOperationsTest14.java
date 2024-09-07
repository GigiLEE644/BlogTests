public class BitOperationsTest14 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4, 4, 5 };

        int odds = 0;

        for (int i = 0; i < arr.length; i++) {
            odds ^= arr[i];
        }

        int mask = oneAtTheMostRightSide(odds);

        int firstOdd = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mask) == 0) {
                firstOdd ^= arr[i];
            }
        }

        int secondOdd = firstOdd ^ odds;

        System.out.println(firstOdd);
        System.out.println(secondOdd);
    }

    private static int oneAtTheMostRightSide(int a) {
        int aa = ~a + 1;

        int aaa = a & (aa);

        return aaa;
    }
}

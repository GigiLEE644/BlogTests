public class BitOperationsTest12 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4, 4, 5, 5 };

        int odd = 0;

        for (int i = 0; i < arr.length; i++) {
            odd ^= arr[i];
        }

        System.out.println("The only odd number in the array is " + odd);
    }
}

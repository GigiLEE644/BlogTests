public class BitOperationsTest9 {
    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        int a = 0;

        for (int i = 0; i < arr1.length; i++) {
            a ^= arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            a ^= arr2[i];
        }

        System.out.println(a);
    }
}

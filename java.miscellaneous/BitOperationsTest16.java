public class BitOperationsTest16 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(1));
        System.out.println(isPowerOf2(2));
        System.out.println(isPowerOf2(3));
        System.out.println(isPowerOf2(4));
        System.out.println(isPowerOf2(5));
        System.out.println(isPowerOf2(6));
        System.out.println(isPowerOf2(7));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(9));
    }

    private static boolean isPowerOf2(int a) {
        if(a < 0) {
            return false;
        }
        
        return a == oneAtTheMostRightSide(a);
    }

    private static int oneAtTheMostRightSide(int a) {
        int aa = a & -a;

        return aa;
    }
}

public class BitOperationsTest16 {
    public static void main(String[] args) {
        System.out.println(is2n(1));
        System.out.println(is2n(2));
        System.out.println(is2n(3));
        System.out.println(is2n(4));
        System.out.println(is2n(5));
        System.out.println(is2n(6));
        System.out.println(is2n(7));
        System.out.println(is2n(8));
        System.out.println(is2n(9));
    }

    private static boolean is2n(int a) {
        return a == oneAtTheMostRightSide(a);
    }

    private static int oneAtTheMostRightSide(int a) {
        int aa = a & -a;

        return aa;
    }
}

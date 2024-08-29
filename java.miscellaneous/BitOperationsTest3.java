public class BitOperationsTest3 {
    public static void main(String[] args) {
        System.out.println(returnFalse() & returnTrue());
        System.out.println();
        System.out.println(returnFalse() && returnTrue());
        System.out.println();
        System.out.println(returnTrue() | returnFalse());
        System.out.println();
        System.out.println(returnTrue() || returnFalse());
    }

    private static boolean returnTrue() {
        System.out.println("Inside returnTrue method");
        return true;
    }

    private static boolean returnFalse() {
        System.out.println("Inside returnFalse method");
        return false;
    }
}

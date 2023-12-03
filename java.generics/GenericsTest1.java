public class GenericsTest1 {
    public static void main(String[] args) {
        System.out.println(max(1, 2));
        System.out.println(max(1f, 2f));
        System.out.println(max(1d, 2d));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static float max(float a, float b) {
        return a > b ? a : b;
    }

    private static double max(double a, double b) {
        return a > b ? a : b;
    }
}
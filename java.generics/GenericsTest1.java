public class GenericsTest1 {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1f, 2f));
        System.out.println(add(1d, 2d));
    }

    private static int add(int a, int b) {
        System.out.println("int : " + a + " + " + b + " = " + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println("float : " + a + " + " + b + " = " + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println("double : " + a + " + " + b + " = " + (a + b));
        return a + b;
    }
}
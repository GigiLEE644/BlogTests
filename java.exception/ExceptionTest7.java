public class ExceptionTest7 {
    public static void main(String[] args) {
        System.out.println(divide(4, 2));

        System.out.println();

        System.out.println(divide(4, 0));
    }

    private static int divide(int a, int b) {
        int c = 0;
        try {
            c = a / b;
            System.out.println("I am in try block.");
            return c;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return c;
        } finally {
            System.out.println("I am in finally block.");
        }
    }
}

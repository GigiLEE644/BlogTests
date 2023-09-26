public class ExceptionTest4 {
    public static void main(String[] args) {
        int result = divide(1, 0);

        System.out.println(result);
    }

    private static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("b can not be 0");
        }

        return a / b;
    }
}

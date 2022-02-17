public class ReturnAddressTest {
    public static void main(String[] args) {
        try {
            div(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int div(int a, int b) {
        return a / b;
    }
}

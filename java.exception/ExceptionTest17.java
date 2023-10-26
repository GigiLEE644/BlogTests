public class ExceptionTest17 {
    public static void main(String[] args) {
        try {
            System.out.println("In Try.");
            int x = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("In Catch.");
            Integer.parseInt(" ");
            e.printStackTrace();
        } finally {
            System.out.println("In finally.");
        }
    }
}

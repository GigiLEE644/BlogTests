public class ExceptionTest18 {
    public static void main(String[] args) {
        try {
            System.out.println("In Try.");
            Integer.parseInt(" ");
        } catch (ArithmeticException e) {
            System.out.println("In Catch.");
            int x = 1 / 0;
            e.printStackTrace();
        } finally {
            System.out.println("In finally.");
        }
    }
}

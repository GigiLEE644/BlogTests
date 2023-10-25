public class ExceptionTest17 {
    public static void main(String[] args) {
        try {
            System.out.println("x");
            //int x = 1 / 0;
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("y");
            e.printStackTrace();
            int y = 1 / 0;
        } finally {
            System.out.println("In finally.");
        }
    }
}

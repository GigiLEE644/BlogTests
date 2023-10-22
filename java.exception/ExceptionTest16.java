public class ExceptionTest16 {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("This is my null pointer exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
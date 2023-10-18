public class ExceptionTest14 {
    public static void main(String[] args) {
        try {
            Long.parseLong("xyz");
        } catch (NumberFormatException e) {
            System.err.println(e);
            throw e;
        }
    }
}

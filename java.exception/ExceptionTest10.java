public class ExceptionTest10 {
    public static void main(String[] args) {
        try {
            throw new ArithmeticException("this is an arithmetic exception");
        } finally {
            throw new RuntimeException("this is a runtime exception");
        }
    }
}

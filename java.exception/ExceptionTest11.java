public class ExceptionTest11 {
    public static void main(String[] args) throws Exception {
        try (MyCloseable mc = new MyCloseable()) {
            throw new ArithmeticException("this is an arithmetic exception");
        }
    }

    private static class MyCloseable implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new RuntimeException("this is a runtime exception");
        }
    }
}

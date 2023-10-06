public class ExceptionTest12 {
    public static void main(String[] args) {
        try (MyCloseable mc = new MyCloseable()) {
            throw new ArithmeticException("this is an arithmetic exception");
        } catch (Exception e) {
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();

            System.out.println();
            System.out.println("Suppressed :");
            System.out.println();

            for (int i = 0; i < suppressed.length; i++) {
                suppressed[i].printStackTrace();
            }
        }
    }

    private static class MyCloseable implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new RuntimeException("this is a runtime exception");
        }
    }
}

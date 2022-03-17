public class FinalizeTest {
    private static Resurrected obj;

    public static void main(String[] args) throws InterruptedException {
        obj = new Resurrected();

        obj = null;

        System.gc();

        System.out.println("GC time");

        Thread.sleep(2000);

        if (obj == null) {
            System.out.println("obj is dead");
        } else {
            System.out.println("obj is still alive");
        }
    }

    private static class Resurrected {
        protected void finalize() throws Throwable {
            obj = this; // if comment this line, obj will be recycled after gc
        }
    }
}

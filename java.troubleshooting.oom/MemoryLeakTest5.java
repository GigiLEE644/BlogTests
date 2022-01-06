import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * -Xms100m -Xmx100m
 */
public class MemoryLeakTest5 {
    public static void main(String[] args) {
        startCheckingFinalizerQueue();

        while (true) {
            new Dummy();
        }
    }

    private static class Dummy {
        @Override
        protected void finalize() throws Throwable {
            // do something in finalize method
            int a = 0;
            int b = 1;
            int c = a + b;
        }
    }

    private static void startCheckingFinalizerQueue() {
        Thread t = new Thread(() -> {
            while (true) {
                check();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private static void check() {
        // print total element's count of finalizer queue every second
        try {
            Thread.sleep(1000);

            Field field = Class.forName("java.lang.ref.Finalizer").getDeclaredField("queue");
            field.setAccessible(true);
            ReferenceQueue<Object> queue = (ReferenceQueue) field.get(null);

            field = ReferenceQueue.class.getDeclaredField("queueLength");
            field.setAccessible(true);
            long queueLength = (long) field.get(queue);

            System.out.format("There are %d elements in finalizer queue.%n", queueLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

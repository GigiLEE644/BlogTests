import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedReentrancy {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(() -> {
                synchronized (counter) {
                    // First time acquiring the lock
                    synchronized (counter) {
                        // I already have the lock
                        // so i can enter here without any issue
                        counter.inc();
                    }
                }
            });
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.sum);
    }

    private static class Counter {
        private int sum = 0;

        void inc() {
            this.sum++;
        }
    }
}
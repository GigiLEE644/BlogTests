import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CasWithAtomicBoolean {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.sum);
    }

    private static class Counter {
        private int sum = 0;

        private AtomicBoolean lock = new AtomicBoolean(false);

        void inc() {
            while (true) {
                if (lock.compareAndSet(false, true)) {
                    this.sum++;
                    lock.set(false);
                    return;
                }
            }
        }
    }
}
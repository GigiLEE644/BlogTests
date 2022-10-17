import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class CasWithAtomicReferenceFieldUpdater {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.count);
    }

    private static class Counter {
        volatile int count;

        AtomicIntegerFieldUpdater<Counter> countFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Counter.class,
                "count");

        void inc() {
            while (true) {
                int expected = this.count;
                int update = expected + 1;
                if (countFieldUpdater.compareAndSet(this, expected, update)) {
                    return;
                }
            }
        }
    }
}

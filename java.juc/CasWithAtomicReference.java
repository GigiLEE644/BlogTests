import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CasWithAtomicReference {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.sum.get());
    }

    private static class Counter {
        private AtomicReference<Integer> sum = new AtomicReference<>(Integer.valueOf(0));

        void inc() {
            while (true) {
                Integer expectedValue = sum.get();
                Integer newValue = expectedValue + 1;
                if (sum.compareAndSet(expectedValue, newValue)) {
                    return;
                }
            }
        }
    }
}

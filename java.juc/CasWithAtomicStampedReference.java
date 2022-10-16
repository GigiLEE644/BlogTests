import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasWithAtomicStampedReference {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.sum.getReference());
    }

    private static class Counter {
        private AtomicStampedReference<Integer> sum = new AtomicStampedReference<>(Integer.valueOf(0), 0);

        void inc() {
            while (true) {
                Integer expectedValue = sum.getReference();
                Integer newValue = expectedValue + 1;

                int expectedStamp = sum.getStamp();
                int newStamp = expectedStamp + 1;

                if (sum.compareAndSet(expectedValue, newValue, expectedStamp, newStamp)) {
                    return;
                }
            }
        }
    }
}

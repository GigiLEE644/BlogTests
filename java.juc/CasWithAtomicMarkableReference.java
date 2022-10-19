import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class CasWithAtomicMarkableReference {
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
        private AtomicMarkableReference<Integer> sum = new AtomicMarkableReference<>(Integer.valueOf(0), true);

        void inc() {
            while (true) {
                Integer expectedValue = sum.getReference();
                Integer newValue = expectedValue + 1;

                boolean expectedMark = sum.isMarked();
                boolean newMark = !expectedMark;

                if (sum.compareAndSet(expectedValue, newValue, expectedMark, newMark)) {
                    return;
                }
            }
        }
    }
}

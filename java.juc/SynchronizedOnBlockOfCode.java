import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedOnBlockOfCode {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        MyLock lock = new MyLock();

        for (int i = 0; i < 1000; i++) {
            service.submit(() -> {
                synchronized (lock) {
                    counter.inc();
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

    private static class MyLock {
    }
}

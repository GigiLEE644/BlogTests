import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        int count = 1000;

        CountDownLatch cdl = new CountDownLatch(count);

        ExecutorService es = Executors.newCachedThreadPool();

        Counter counter = new Counter();

        try {
            for (int i = 0; i < count; i++) {
                es.execute(() -> {
                    counter.add();
                    cdl.countDown();
                });
            }
        } finally {
            es.shutdown();
        }

        cdl.await();

        System.out.println(counter.get());
    }

    private static class Counter {
        private int count = 0;

        void add() {
            this.count++;
        }

        int get() {
            return this.count;
        }
    }
}

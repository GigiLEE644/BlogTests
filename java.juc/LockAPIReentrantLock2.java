import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPIReentrantLock2 {
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

        private Lock lock = new ReentrantLock();

        void inc() {
            while (true) {
                if (this.lock.tryLock()) {
                    try {
                        this.sum++;
                        return;
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }
    }
}
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public class SemaphoreTest2 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore mutex = new Semaphore(3);

        final int loop = 100000;

        AtomicReference<Integer> counter = new AtomicReference<>(0);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < loop; i++) {
                try {
                    mutex.acquire();
                    int current = counter.get();
                    counter.set(++current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < loop; i++) {
                try {
                    mutex.acquire(3);
                    int current = counter.get();
                    counter.set(--current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release(3);
                }
            }
        });

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("Final counter value = " + counter.get());
    }
}

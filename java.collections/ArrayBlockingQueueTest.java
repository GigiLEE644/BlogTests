import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        int count = 5;

        AtomicInteger producerWait = new AtomicInteger(1);
        AtomicInteger consumerWait = new AtomicInteger(2);

        Runnable producer = () -> {
            for (int i = 1; i <= count; i++) {
                try {
                    if (producerWait.get() <= consumerWait.get()) {
                        System.out
                                .println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : putting");
                    }
                    TimeUnit.SECONDS.sleep(producerWait.get());
                    queue.put(i);
                    if (producerWait.get() <= consumerWait.get()) {
                        System.out.println(
                                "[" + Instant.now() + "] " + Thread.currentThread().getName() + " : putting " + i
                                        + " done");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 1; i <= count; i++) {
                try {
                    if (consumerWait.get() <= producerWait.get()) {
                        System.out
                                .println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : taking");
                    }
                    TimeUnit.SECONDS.sleep(consumerWait.get());
                    int taken = queue.take();
                    if (consumerWait.get() <= producerWait.get()) {
                        System.out.println(
                                "[" + Instant.now() + "] " + Thread.currentThread().getName() + " : taking "
                                        + taken
                                        + " done");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread p1 = new Thread(producer);
        Thread c1 = new Thread(consumer);

        p1.start();
        c1.start();

        p1.join();
        c1.join();

        System.out.println();

        producerWait.set(2);
        consumerWait.set(1);

        Thread p2 = new Thread(producer);
        Thread c2 = new Thread(consumer);

        p2.start();
        c2.start();

        c2.join();
        p2.join();
    }
}

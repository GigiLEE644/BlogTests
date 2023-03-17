import java.time.Instant;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        Runnable producer = () -> {
            String greeting = "hello world";
            System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : transfering");
            try {
                queue.transfer(greeting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : transfering "
                    + greeting + " done");
        };

        Runnable consumer = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                String greeting = queue.take();
                System.out.println(
                        "[" + Instant.now() + "] " + Thread.currentThread().getName() + " : taking " + greeting
                                + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread p1 = new Thread(producer);
        Thread c1 = new Thread(consumer);

        p1.start();
        c1.start();

        p1.join();
        c1.join();
    }
}
import java.time.Instant;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        Runnable producer = () -> {
            try {
                String greeting = "hello world";
                System.out.println(
                        "[" + Instant.now() + "] " + Thread.currentThread().getName() + " : transfering ...");
                queue.transfer(greeting);
                System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName()
                        + " : transfered " + greeting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(producer, "producer").start();

        TimeUnit.SECONDS.sleep(3);

        String greeting = queue.take();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : " + greeting);
    }
}
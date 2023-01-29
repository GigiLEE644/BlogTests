import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Runnable r = () -> {
            log("start");
            sleep(3);
            log("done");
            latch.countDown();
        };

        log("start");

        new Thread(r).start();
        new Thread(r).start();

        latch.await();

        log("done");
    }

    private static void log(String message) {
        System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : " + message);
    }

    private static void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

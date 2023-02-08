import java.time.Instant;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest1 {
    public static void main(String[] args) throws InterruptedException {
        Phaser ph = new Phaser(3);

        log("start");

        Runnable r = () -> {
            log("start");
            sleep(3);
            log("done");
            ph.arrive();
        };

        new Thread(r).start();
        new Thread(r).start();

        ph.arriveAndAwaitAdvance();

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

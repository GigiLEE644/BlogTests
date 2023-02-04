import java.time.Instant;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest1 {
    public static void main(String[] args) throws InterruptedException {
        Phaser ph = new Phaser(1);

        log("start");

        new Thread(new Task(ph)).start();
        new Thread(new Task(ph)).start();

        ph.arriveAndAwaitAdvance();

        log("done");
    }

    private static class Task implements Runnable {
        private Phaser ph;

        Task(Phaser ph) {
            this.ph = ph;
            this.ph.register();
        }

        @Override
        public void run() {
            log("start");
            sleep(3);
            log("done");
            ph.arrive();
        }
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

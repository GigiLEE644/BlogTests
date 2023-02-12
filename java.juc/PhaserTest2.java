import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest2 {
    public static void main(String args[]) throws Exception {
        int nbWorkers = 5;

        Phaser phaser = new Phaser(nbWorkers);

        ExecutorService es = Executors.newFixedThreadPool(nbWorkers);

        try {
            for (int i = 1; i <= nbWorkers; i++) {
                es.execute(work(i, phaser));
            }
        } finally {
            es.shutdown();
        }

        System.out.println(Thread.currentThread().getName() + " : done");
    }

    private static Runnable work(int duration, Phaser phaser) {
        return () -> {
            try {
                String name = Thread.currentThread().getName();
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("[" + Instant.now() + "] " + name + " : ready");
                phaser.arriveAndAwaitAdvance();
                System.out.println("[" + Instant.now() + "] " + name + " : work");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
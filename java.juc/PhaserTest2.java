import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest2 {
    public static void main(String[] args) throws InterruptedException {
        // create an executor service
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        Phaser phaser = new Phaser(2);
        try {
            // register main thread with the phaser
            int arrivalPhase = phaser.register();
            // simulate work by two threads that synchronize 10 times at the barrier
            for (int i = 0; i < 2; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 15; i++) {
                            phaser.arriveAndAwaitAdvance();
                            // simulate worker threads execute some other tasks after 10 iterations
                            if (i > 10) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ie) {
                                    // ignore for now
                                }
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " proceeding forward.");
                    }
                });
            }
            while (arrivalPhase < 10) {
                arrivalPhase = phaser.arriveAndAwaitAdvance();
                System.out.println("main thread arrived at phase " + arrivalPhase);
            }
            // non-blocking call
            phaser.arriveAndDeregister();
            System.out.println("main thread past the barrier");
        } finally {
            // remember to shutdown the executor
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        }
    }
}

// https://medium.com/double-pointer/guide-to-phaser-in-java-efd810e4fc1b
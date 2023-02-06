import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest2 {
    public static void main(String args[]) throws Exception {
        // create an executor service
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        // create an instance of Phaser with 3 registered parties
        Phaser phaser = new Phaser() {
            protected boolean onAdvance(int phase, int registeredParties) {
                // print the current phase BEFORE advancing and the registered parties
                System.out.println("\n" + Thread.currentThread().getName()
                        + " is performing onAdvance action. Advancing from phase " + phase + " with registeredParties "
                        + registeredParties);
                // return true when 5 iterations are complete
                return phase >= 4 || registeredParties == 0;
            }
        };
        try {
            // register the threads that'll synchronize on the barrier
            phaser.bulkRegister(3);
            // submit three tasks that'll synchronize on our instance of `MyPhaser`
            for (int i = 0; i < 3; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        // repeatedly synchronize until the barrier is in terminated state
                        while (!phaser.isTerminated()) {
                            int phase = phaser.arriveAndAwaitAdvance();
                            System.out.println(Thread.currentThread().getName() + " has advanced to phase " + phase);
                        }
                    }
                });
            }
        } finally {
            // remember to shutdown the executor
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        }
        System.out.println("is terminated " + phaser.isTerminated());
    }
}

// https://medium.com/double-pointer/guide-to-phaser-in-java-efd810e4fc1b
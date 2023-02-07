import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest2 {
    public static void main(String args[]) throws Exception {
        // create an executor service
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        // initially create a parent phaser which has no registered party
        Phaser phaserParent = new Phaser(0);
        // producer phaser has three parties, one for each producer
        Phaser producersPhaser = new Phaser(phaserParent, 3);
        // consumer phaser has five parties, including the three producers
        // so that we can have the consumers wait until the producers are done
        Phaser consumerPhaser = new Phaser(phaserParent, 2);
        phaserParent.register();
        System.out.println("Registered party count for parentPhaser " + phaserParent.getRegisteredParties());
        try {
            // create 3 producer threads
            for (int i = 0; i < 3; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        // all producers reach barrier and then start producing
                        producersPhaser.arriveAndAwaitAdvance();
                        // ... work to produce.
                        System.out.println(Thread.currentThread().getName() + " producer finished at parent phase "
                                + phaserParent.getPhase());
                        // Now wait for consumers to get done.
                        producersPhaser.arrive();
                        phaserParent.awaitAdvance(1);
                        // unblock the main thread
                        producersPhaser.arrive();
                    }
                });
            }
            // create two consumer threads
            for (int i = 0; i < 2; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        // wait for producers to get done
                        while (phaserParent.getPhase() <= 1) {
                            consumerPhaser.arriveAndAwaitAdvance();
                        }
                        // ... work to consume
                        System.out.println(Thread.currentThread().getName() + " consumer finished at parent phase "
                                + phaserParent.getPhase());
                        // Now unblock the main thread
                        consumerPhaser.arrive();
                    }
                });
            }
            // get the producers going
            phaserParent.arrive();
            // wait for the producers to be done
            phaserParent.awaitAdvance(0);
            // get the consumers going
            phaserParent.arrive();
            // wait for consumers to get done
            phaserParent.awaitAdvance(1);
            // wait for both consumer and producers to exit
            phaserParent.arriveAndAwaitAdvance();
            System.out.println("main thread existing at parent phase " + phaserParent.getPhase());
        } finally {
            // remember to shutdown the executor
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        }

    }
}
// https://medium.com/double-pointer/guide-to-phaser-in-java-efd810e4fc1b
import java.time.Instant;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest1 {
    public static void main(String[] args) {
        int nbWorkers = 5;

        CyclicBarrier barrier = new CyclicBarrier(nbWorkers, () -> System.out.println("All start to work"));

        ExecutorService es = Executors.newFixedThreadPool(nbWorkers);

        try {
            for (int i = 1; i <= 5; i++) {
                es.execute(work(i, barrier));
            }
        } finally {
            es.shutdown();
        }

        System.out.println(Thread.currentThread().getName() + " : done");
    }

    private static Runnable work(int duration, CyclicBarrier barrier) {
        return () -> {
            try {
                String name = Thread.currentThread().getName();
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("[" + Instant.now() + "] " + name + " : ready");
                barrier.await();
                System.out.println("[" + Instant.now() + "] " + name + " : work");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Java21NewFeaturesTest10 {

        public static void main(String[] args) throws InterruptedException {
                ThreadFactory f = Thread.ofVirtual().factory();

                ExecutorService e = Executors.newFixedThreadPool(2, f);

                for (int i = 0; i < 10; i++) {
                        e.submit(() -> {
                                System.out.println("Running task in thread : "
                                                + Thread.currentThread());
                        });
                }

                e.shutdown();

                Thread.currentThread().join();
        }
}
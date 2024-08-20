import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java21NewFeaturesTest9 {

        public static void main(String[] args) throws InterruptedException {
                ExecutorService e = Executors.newVirtualThreadPerTaskExecutor();

                for (int i = 0; i < 10; i++) {
                        e.submit(() -> {
                                System.out.println("Running task in thread : " + Thread.currentThread());
                        });
                }

                e.shutdown();

                Thread.currentThread().join();
        }
}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedOnStaticMethod {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            service.submit(Counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + Counter.sum);
    }

    private static class Counter {
        private static int sum = 0;

        static synchronized void inc() {
            sum++;
        }
    }
}

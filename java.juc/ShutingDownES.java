import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutingDownES {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;
                es.execute(
                        () -> System.out.println(
                                Thread.currentThread().getName() + " : executing task " + taskNumber));
            }
        } finally {
            es.shutdown();

            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        }
    }
}

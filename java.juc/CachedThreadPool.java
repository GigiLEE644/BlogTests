import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;
                es.execute(
                        () -> System.out.println(
                                Thread.currentThread().getName() + " : executing task " + taskNumber));
            }
        } finally {
            es.shutdown();
        }
    }
}

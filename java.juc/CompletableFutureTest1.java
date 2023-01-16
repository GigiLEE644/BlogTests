import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = new CompletableFuture<>();

        ExecutorService pool = Executors.newSingleThreadExecutor();

        try {
            pool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cf.complete("hello world");
                }
            });
        } finally {
            pool.shutdown();
        }

        System.out.println(cf.get());
    }
}
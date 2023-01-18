import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest4 {
        public static void main(String[] args) throws InterruptedException, ExecutionException {
                ExecutorService es = Executors.newSingleThreadExecutor();

                try {
                        CompletableFuture
                                        .supplyAsync(() -> "[ 1. " + Thread.currentThread().getName()
                                                        + " : supplyAsync = hello world ]", es)
                                        .thenApplyAsync(g -> "[ 2. " + Thread.currentThread().getName()
                                                        + " : thenApplyAsync = " + g + " ]", es)
                                        .thenAcceptAsync(g -> System.out
                                                        .println("[ 3. " + Thread.currentThread().getName()
                                                                        + " : thenAcceptAsync = " + g
                                                                        + " ]"),
                                                        es);
                } finally {
                        Thread.sleep(3000);
                        es.shutdown();
                }
        }
}

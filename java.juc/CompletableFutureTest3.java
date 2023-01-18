import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest3 {
        public static void main(String[] args) throws InterruptedException, ExecutionException {
                CompletableFuture
                                .supplyAsync(() -> "[ 1. " + Thread.currentThread().getName()
                                                + " : supplyAsync = hello world ]")
                                .thenApplyAsync(g -> "[ 2. " + Thread.currentThread().getName() + " : thenApplyAsync = "
                                                + g + " ]")
                                .thenAcceptAsync(g -> System.out
                                                .println("[ 3. " + Thread.currentThread().getName()
                                                                + " : thenAcceptAsync = " + g + " ]"));

                Thread.sleep(3000);
        }
}

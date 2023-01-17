import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture
                .supplyAsync(() -> "[ 1. " + Thread.currentThread().getName() + " : supplyAsync = hello world ]")
                .thenApply(g -> "[ 2. " + Thread.currentThread().getName() + " : thenApply = " + g + " ]")
                .thenAccept(g -> System.out
                        .println("[ 3. " + Thread.currentThread().getName() + " : thenAccept = " + g + " ]"));

        System.out.println();

        CompletableFuture
                .supplyAsync(() -> "[ 1. " + Thread.currentThread().getName() + " : supplyAsync = hello world ]")
                .thenApplyAsync(g -> "[ 2. " + Thread.currentThread().getName() + " : thenApplyAsync = " + g + " ]")
                .thenAcceptAsync(g -> System.out
                        .println("[ 3. " + Thread.currentThread().getName() + " : thenAcceptAsync = " + g + " ]"));

        System.out.println();

        ExecutorService es = Executors.newSingleThreadExecutor();

        CompletableFuture
                .supplyAsync(() -> "[ 1. " + Thread.currentThread().getName()
                        + " : supplyAsync with ExecutorService = hello world ]", es)
                .thenApplyAsync(g -> "[ 2. " + Thread.currentThread().getName()
                        + " : thenApplyAsync with ExecutorService = " + g + " ]", es)
                .thenAcceptAsync(g -> System.out
                        .println("[ 3. " + Thread.currentThread().getName()
                                + " : thenAcceptAsync with ExecutorService = " + g + " ]"),
                        es);
    }
}

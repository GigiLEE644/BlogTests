import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // CompletableFuture<String> cf =
        // CompletableFuture.completedFuture(Thread.currentThread().getName() + " :
        // hello world");

        CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " : hello world")
                .thenApply(g -> Thread.currentThread().getName() + " : " + g)
                .thenAccept(g -> System.out.println(Thread.currentThread().getName() + " : " + g));

        System.out.println();

        CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " : hello world")
                .thenCompose(g -> CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " : " + g))
                .thenAccept(g -> System.out.println(Thread.currentThread().getName() + " : " + g));
    }
}

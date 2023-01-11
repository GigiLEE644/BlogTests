import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // CompletableFuture<String> cf =
        // CompletableFuture.completedFuture(Thread.currentThread().getName() + " :
        // hello world");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName() + " : hello world";
        });

        System.out.println(cf.get());

        cf = cf.thenApply(g -> {
            return Thread.currentThread().getName() + " : " + g;
        });

        System.out.println(cf.get());

        cf.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}

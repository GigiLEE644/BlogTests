import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f1 = CompletableFuture
                .supplyAsync(() -> Thread.currentThread().getName() + " : hello");

        CompletableFuture<String> f2 = CompletableFuture
                .supplyAsync(() -> Thread.currentThread().getName() + " : world");

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);

        f.get();

        // String r1 = f1.isDone() ? f1.join() : "";
        // String r2 = f2.isDone() ? f2.join() : "";

        String r1 = f1.isDone() ? f1.join() : "";
        String r2 = f2.isDone() ? f2.join() : "";

        System.out.println(r1);
        System.out.println(r2);
    }
}

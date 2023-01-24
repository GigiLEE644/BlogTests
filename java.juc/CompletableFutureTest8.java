import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest8 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f = CompletableFuture
                .supplyAsync(() -> {
                    int result = 1 / 0;
                    return Thread.currentThread().getName() + " : hello world";
                })
                .exceptionally(error -> {
                    return Thread.currentThread().getName() + " : " + error.getCause().getMessage();
                });

        String greeting = f.get();

        System.out.println(greeting);
    }
}

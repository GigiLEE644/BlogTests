import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f = CompletableFuture
                .supplyAsync(() -> "hello")
                .thenCompose((g) -> {
                    return CompletableFuture.supplyAsync(() -> g + " world");
                });

        String greeting = f.get();

        System.out.println(greeting);
    }
}
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f = CompletableFuture
                .supplyAsync(() -> {
                    // int result = 1 / 0;
                    return Thread.currentThread().getName() + " : hello world";
                })
                .handle((g, t) -> {
                    if (t == null) {
                        return Thread.currentThread().getName() + " : " + g;
                    }

                    return Thread.currentThread().getName() + " : " + t.getCause().getMessage();
                });

        // f.completeExceptionally(new RuntimeException("this is an exception"));

        String greeting = f.get();

        System.out.println(greeting);
    }
}

import java.util.concurrent.CompletableFuture;

public class Java21NewFeaturesTest8 {

        public static void main(String[] args) {
                CompletableFuture<Void> future = CompletableFuture
                                .supplyAsync(() -> "hello world")
                                .thenApplyAsync(greeting -> greeting.toUpperCase())
                                .thenAcceptAsync(greeting -> {
                                        System.out.println(Thread.currentThread() + " : " + greeting);
                                });

                future.join();
        }
}
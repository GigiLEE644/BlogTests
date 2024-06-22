import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java11NewFeaturesTest8 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            HttpClient httpClient = HttpClient.newBuilder().executor(executorService)
                    .version(HttpClient.Version.HTTP_1_1)
                    .connectTimeout(Duration.ofSeconds(10)).build();

            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080")).build();

            CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request,
                    HttpResponse.BodyHandlers.ofString());

            responseFuture.thenAccept(response -> {
                System.out.println(response.statusCode());

                System.out.println();

                System.out.println(response.body());
            }).join();
        } finally {
            executorService.shutdown();
        }
    }
}
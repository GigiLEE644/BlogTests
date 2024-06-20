import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Java11NewFeaturesTest7 {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10)).build();

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.fr/")).build();

        CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request,
                HttpResponse.BodyHandlers.ofString());

        responseFuture.thenAccept(response -> {
            response.headers().map().forEach((k, v) -> System.out.println(k + ":" + v));

            System.out.println();

            System.out.println(response.statusCode());

            System.out.println();

            System.out.println(response.body());
        }).join();
    }
}
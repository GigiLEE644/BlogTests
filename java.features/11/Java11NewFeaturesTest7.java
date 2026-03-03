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

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080")).build();

        CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request,
                HttpResponse.BodyHandlers.ofString());

        responseFuture.thenAccept(response -> {
            System.out.println(response.statusCode());

            System.out.println();

            System.out.println(response.body());
        }).join();
    }
}
/**
 * Output:
        [ Client ]
 
        200

        Wed Jun 12 14:30:00 CST 2024

        [ Server ]
        
        Listening for connection on port 8080 ....
        GET / HTTP/1.1
        Host: localhost:8080
        User-Agent: Java-http-client/11.0.1
*/
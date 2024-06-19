import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Java11NewFeaturesTest6 {

    public static void main(String[] args) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
                    .connectTimeout(Duration.ofSeconds(10)).build();

            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.fr/")).build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            response.headers().map().forEach((k, v) -> System.out.println(k + ":" + v));

            System.out.println();

            System.out.println(response.statusCode());

            System.out.println();

            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
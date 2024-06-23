import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Java11NewFeaturesTest9 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Map<Object, Object> data = new HashMap<>();
        data.put("name", "tom");
        data.put("age", "18");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create("http://localhost:8080"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        System.out.println(response.body());
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Java11NewFeaturesTest10 {

    public static void main(String[] args) throws IOException, InterruptedException {

        String json = new StringBuilder()
                .append("{")
                .append("\"name\":\"tom\",")
                .append("\"age\":\"18\"")
                .append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8080"))
                .header("Content-Type", "application/json")
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        System.out.println(response.body());
    }
}
/**
 * Output:
        [ Client ]
 
        200

        Wed Jun 12 14:30:00 CST 2024

        [ Server ]
        
        Listening for connection on port 8080 ....
        POST / HTTP/1.1
        Content-Length: 25
        Host: localhost:8080
        User-Agent: Java-http-client/11.0.1
        Content-Type: application/json
        {"name":"tom","age":"18"}
*/
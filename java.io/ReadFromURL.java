import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromURL {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.google.fr/");

        System.out.println("protocol = " + url.getProtocol());
        System.out.println("host = " + url.getHost());
        System.out.println("path = " + url.getPath());
        System.out.println("port = " + url.getPort());
        System.out.println("file = " + url.getFile());

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

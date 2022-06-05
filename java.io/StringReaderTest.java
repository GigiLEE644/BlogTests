import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class StringReaderTest {
    public static void main(String[] args) throws IOException {
        String content = """
                hello java
                bonjour java
                """;

        try (BufferedReader reader = new BufferedReader(new StringReader(content))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

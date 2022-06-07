import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "this is a test!".getBytes();

        try (InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(bytes),
                StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];

            StringBuilder sb = new StringBuilder();

            while (reader.read(buffer) != -1) {
                sb.append(buffer);
            }

            System.out.println(sb.toString());
        }
    }
}

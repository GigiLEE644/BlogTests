import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream("this is a test!".getBytes()))) {
            char[] buffer = new char[1024];

            StringBuilder sb = new StringBuilder();

            while (reader.read(buffer) != -1) {
                sb.append(buffer);
            }

            System.out.println(sb.toString());
        }
    }
}

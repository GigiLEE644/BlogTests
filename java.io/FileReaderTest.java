import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/README.md";
        try (FileReader reader = new FileReader(path)) {
            char[] buffer = new char[1024];

            while (reader.read(buffer) != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(buffer);
                System.out.println(sb.toString());
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/README.md";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(System.out::println);
        }
    }
}

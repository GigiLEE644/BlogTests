import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/greeting";
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("hello world");
        }
    }
}

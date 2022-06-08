import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/greeting";

        try (OutputStreamWriter writer = new OutputStreamWriter(
            new FileOutputStream(path), StandardCharsets.UTF_8)) {
            writer.write("hello world");
            writer.write(System.getProperty("line.separator"));
        }
    }
}

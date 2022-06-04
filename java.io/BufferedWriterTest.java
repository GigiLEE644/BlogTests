import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/greeting";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("hello");
            writer.newLine();
            writer.write("bonjour");
            writer.newLine();
        }
    }
}

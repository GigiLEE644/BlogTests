import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/home/yan/github/BlogTests/greeting";

        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println("hello world");
        }
    }
}

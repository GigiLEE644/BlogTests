import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingTemporaryFile {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/home/yan/github/BlogTests";

        Path dirPath = Paths.get(directoryPath);

        Files.createTempFile(dirPath, "hello", "world");
    }
}

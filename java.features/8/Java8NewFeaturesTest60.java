import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java8NewFeaturesTest60 {
    public static void main(String[] args) {
        String prefix = "hello";
        String suffix = "world";
        String content = "hi, helloworld!";

        Path path = generateTempFile(prefix, suffix, content);

        readFileByStream(path);
    }

    private static void readFileByStream(Path path) {
        if (path != null) {
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Path generateTempFile(String prefix, String suffix, String content) {
        try {
            File tempFile = File.createTempFile(prefix, suffix);
            tempFile.deleteOnExit();

            Path path = Paths.get(tempFile.getAbsolutePath());

            Files.write(path, content.getBytes());

            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

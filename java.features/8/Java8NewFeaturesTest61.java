import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java8NewFeaturesTest61 {
    public static void main(String[] args) {
        String prefix = "helloworld";
        String suffix = ".txt";
        String content = "hi, helloworld!";

        Path filePath = generateTempFile(prefix, suffix, content);

        if (filePath != null) {
            Path folderPath = filePath.getParent();

            try (Stream<Path> paths = Files.list(folderPath)) {
                paths.filter(p -> p.toString()
                        .endsWith(suffix))
                        .forEach(p -> {
                            System.out.println(p);

                            readFileByStream(p);
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

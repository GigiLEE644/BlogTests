import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingDirectories {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/home/yan/github/BlogTests/hello/world";

        Path dirPath = Paths.get(directoryPath);

        System.out.println("Directory = " + directoryPath);

        System.out.println("Directory exists = " + Files.exists(dirPath));

        Files.createDirectories(dirPath);

        System.out.println("Directory exists = " + Files.exists(dirPath));
    }
}

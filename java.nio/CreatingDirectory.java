import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingDirectory {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/home/yan/github/BlogTests/hello";

        Path dirPath = Paths.get(directoryPath);

        System.out.println("Directory = " + directoryPath);

        System.out.println("Directory exists = " + Files.exists(dirPath));

        Files.createDirectory(dirPath);

        System.out.println("Directory exists = " + Files.exists(dirPath));
    }
}

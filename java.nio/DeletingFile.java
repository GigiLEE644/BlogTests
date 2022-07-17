import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeletingFile {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/yan/github/BlogTests/greeting";

        Path dirPath = Paths.get(filePath);

        Files.createDirectory(dirPath);

        Path path = dirPath.resolve("hello");

        Files.createFile(path);

        System.out.println("File = " + path);
        System.out.println("File exists = " + Files.exists(path));

        Files.deleteIfExists(path);

        System.out.println("File exists = " + Files.exists(path));

        Files.delete(dirPath);
    }
}

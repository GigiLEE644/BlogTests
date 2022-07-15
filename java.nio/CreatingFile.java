import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingFile {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/yan/github/BlogTests/greeting";

        System.out.println("File = " + filePath);

        Path path = Paths.get(filePath);

        System.out.println("File exists = " + Files.exists(path));

        Files.createFile(path);

        System.out.println("File exists = " + Files.exists(path));
    }
}

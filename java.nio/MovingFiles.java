import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MovingFiles {
    public static void main(String[] args) throws IOException {
        String sourcePath = "/home/yan/github/BlogTests/greeting";

        Path source = Paths.get(sourcePath);

        Files.createFile(source);

        String targetPath = "/home/yan/github/BlogTests/greeting2";

        Path target = Paths.get(targetPath);

        System.out.println("Source File exists = " + Files.exists(source));
        System.out.println("Target File exists = " + Files.exists(target));

        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Source File exists = " + Files.exists(source));
        System.out.println("Target File exists = " + Files.exists(target));
    }
}

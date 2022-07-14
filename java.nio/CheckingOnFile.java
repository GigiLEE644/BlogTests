import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingOnFile {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/yan/github/BlogTests/greeting1";

        Path path = Paths.get(filePath);

        System.out.println("File = " + filePath);
        System.out.println("File exists = " + Files.exists(path));
        System.out.println("File not exists = " + Files.notExists(path));
        System.out.println("File is regular file = " + Files.isRegularFile(path));
        System.out.println("File is directory = " + Files.isDirectory(path));
        System.out.println("File is readable = " + Files.isReadable(path));
        System.out.println("File is writable = " + Files.isWritable(path));
        System.out.println("File is executable = " + Files.isExecutable(path));

        String filePath2 = "/home/yan/github/BlogTests/greeting2";

        Path path2 = Paths.get(filePath2);

        System.out.println("File2 = " + filePath2);
        System.out.println("File is the same file as File2 = " + Files.isSameFile(path, path2));
    }
}

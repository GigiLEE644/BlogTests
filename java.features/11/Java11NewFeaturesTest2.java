import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Java11NewFeaturesTest2 {

    public static void main(String[] args) {
        try {
            File tempFile = File.createTempFile("greeting", ".txt");
            tempFile.deleteOnExit();

            Path filePath = Files.writeString(tempFile.toPath(), "hello world");

            String fileContent = Files.readString(filePath);

            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
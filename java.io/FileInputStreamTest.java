import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        URL url = FileInputStreamTest.class.getResource("FileInputStreamTest.class");

        String path = url.getPath();

        System.out.println(path);

        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] bytes = fis.readAllBytes();

            System.out.println("File Size = " + bytes.length);
        }
    }
}

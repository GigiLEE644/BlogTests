import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/greeting";

        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] bytes = new byte[1024];

            fos.write(bytes);
        }
    }
}

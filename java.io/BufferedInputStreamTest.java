import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/README.md";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
            byte[] bytes = bis.readAllBytes();
            System.out.println(new String(bytes));
        }
    }
}

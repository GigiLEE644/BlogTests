import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "hello world".getBytes();
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(bytes);

            byte[] allBytes = baos.toByteArray();

            System.out.println(new String(allBytes));
        }
    }
}

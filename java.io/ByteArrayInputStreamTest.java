import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {
        byte[] greeting = "hello world".getBytes();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(greeting)) {
            byte[] bytes = bais.readAllBytes();

            System.out.println(new String(bytes));
        }
    }
}

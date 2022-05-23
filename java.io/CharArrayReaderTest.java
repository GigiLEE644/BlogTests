import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderTest {
    public static void main(String[] args) throws IOException {
        String s = "hello world";
        try (CharArrayReader reader = new CharArrayReader(s.toCharArray())) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        }
    }
}

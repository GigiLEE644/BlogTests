import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayWriterTest {
    public static void main(String[] args) throws IOException {
        String s = "hello world";
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(s);

            char[] chs = writer.toCharArray();

            System.out.println(chs);
        }
    }
}

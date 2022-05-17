import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader("hello world");

        BufferedReader reader = new BufferedReader(sr);

        String s = reader.readLine();

        System.out.println(s);
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {
    public static void main(String[] args) throws IOException {
        try {
            int div = 1 / 0;
        } catch (Exception e) {
            try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                e.printStackTrace(pw);
                System.out.println("Exception caught with stack trace = ");
                System.out.println(sw.toString());
            }
        }
    }
}

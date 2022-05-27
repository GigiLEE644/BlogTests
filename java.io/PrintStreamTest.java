import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println(100 / 0);
        } catch (Exception e) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos)) {
                e.printStackTrace(ps);
                System.out.println("Stack Trace of Exception is :");
                System.out.println(baos.toString());
            }
        }
    }
}

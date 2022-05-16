import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(baos);

        writer.write("this is a test!!");
        writer.close();

        byte[] bytes = baos.toByteArray();

        System.out.println(new String(bytes));
    }
}

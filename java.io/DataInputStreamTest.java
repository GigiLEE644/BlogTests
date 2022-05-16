import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamTest {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("this is a test !!!".getBytes());

        DataInputStream dis = new DataInputStream(bais);

        byte[] buffer = new byte[dis.available()];

        dis.read(buffer);
        dis.close();

        System.out.println(new String(buffer));
    }
}

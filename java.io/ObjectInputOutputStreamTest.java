import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String s = new String("hello");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(s);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(bais);

        String ss = (String) ois.readObject();
        ois.close();

        System.out.println(ss);
    }
}

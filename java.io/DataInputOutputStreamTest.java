import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "/home/yan/github/BlogTests/person";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            dos.writeUTF("tom");
            dos.writeInt(18);
            dos.writeBoolean(true);

            dos.writeUTF("jerry");
            dos.writeInt(16);
            dos.writeBoolean(true);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available() > 0) {
                String name = dis.readUTF();
                int age = dis.readInt();
                boolean male = dis.readBoolean();

                System.out.print(name);
                System.out.print(" ");
                System.out.print(age);
                System.out.print(" ");
                System.out.print(male);
                System.out.println();
            }
        }
    }
}

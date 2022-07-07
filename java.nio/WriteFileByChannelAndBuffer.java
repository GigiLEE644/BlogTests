import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFileByChannelAndBuffer {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/greeting";

        try (FileOutputStream fos = new FileOutputStream(path);
                FileChannel channel = fos.getChannel()) {
            StringBuilder sb = new StringBuilder("hello");
            sb.append(System.lineSeparator());
            String greeting = sb.toString();

            ByteBuffer buffer = ByteBuffer.wrap(greeting.getBytes());
            channel.write(buffer);
        }
    }
}

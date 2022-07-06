import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileByChannelAndBuffer {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/README.md";

        try (FileInputStream fis = new FileInputStream(path);) {
            FileChannel channel = fis.getChannel();

            int bufferSize = 10;

            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }

            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
            StringBuilder sb = new StringBuilder();
            while (channel.read(buffer) > 0) {
                sb.append(new String(buffer.array(), 0, buffer.position()));
                buffer.clear();
            }

            System.out.println(sb.toString());
        }
    }
}

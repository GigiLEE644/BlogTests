import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileByChannelAndBuffer {
    public static void main(String[] args) throws IOException {
        String source = "/home/yan/github/BlogTests/greeting";
        String target = "/home/yan/github/BlogTests/greetingCopy";

        try (FileInputStream fis = new FileInputStream(source);
                FileChannel fisc = fis.getChannel();
                FileOutputStream fos = new FileOutputStream(target);
                FileChannel fosc = fos.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (fisc.read(buffer) > 0) {
                buffer.flip();
                fosc.write(buffer);
                buffer.clear();
            }
        }
    }
}

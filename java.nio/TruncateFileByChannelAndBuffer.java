import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TruncateFileByChannelAndBuffer {
    public static void main(String[] args) throws IOException {
        String input = "hello world";

        try (FileOutputStream fout = new FileOutputStream("/home/yan/github/BlogTests/greeting");
                FileChannel channel = fout.getChannel()) {
            ByteBuffer buff = ByteBuffer.wrap(input.getBytes());
            channel.write(buff);
            channel.truncate(5);
        }
    }
}
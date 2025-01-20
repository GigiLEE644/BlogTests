import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelAndBuffer2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // echo -e "123456789\c" > numbers
        String path = "/home/yan/github/BlogTests/numbers";

        try (FileInputStream fis = new FileInputStream(path);) {
            FileChannel channel = fis.getChannel();

            int bufferSize = 8;

            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }

            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

            info(buffer);

            read(channel, buffer);

            info(buffer);

            show(buffer);

            // doing a flip between two times of read will be the same as doing a clear
            flip(buffer);

            info(buffer);

            show(buffer);

            read(channel, buffer);

            info(buffer);

            show(buffer);
        }
    }

    private static void flip(ByteBuffer buffer) {
        System.out.println();
        System.out.println("flip buffer");
        buffer.flip();
    }

    private static void read(FileChannel channel, ByteBuffer buffer) throws IOException {
        System.out.println();
        System.out.println("read " + channel.read(buffer) + " bytes to buffer");
    }

    private static void show(ByteBuffer buffer) {
        System.out.println();
        System.out.println("buffer content = " + new String(buffer.array()));
    }

    private static void info(ByteBuffer buffer) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("buffer capacity = " + buffer.capacity());
        System.out.println("buffer position = " + buffer.position());
        System.out.println("buffer limit = " + buffer.limit());
        System.out.println("buffer remaining = limit - position = " + buffer.remaining());
        System.out.println("----------------------------------------");
    }
}

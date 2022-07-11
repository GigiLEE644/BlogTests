import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapFileSectionIntoMemoryReadWriteMode {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/greeting";
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw"); FileChannel channel = raf.getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
            if (buffer.hasRemaining()) {
                byte[] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);
                System.out.println(new String(bytes));
            }

            buffer.clear();
            buffer.put("nihao".getBytes());
        }
    }
}

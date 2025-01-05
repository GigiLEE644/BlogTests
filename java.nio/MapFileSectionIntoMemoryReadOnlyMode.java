import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapFileSectionIntoMemoryReadOnlyMode {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/greeting";
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw"); FileChannel channel = raf.getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, 5);
            display(buffer);

            buffer.clear();
            buffer.put("nihao".getBytes());
        }
    }

    private static void display(MappedByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            System.out.println(new String(bytes));
        }
    }
}

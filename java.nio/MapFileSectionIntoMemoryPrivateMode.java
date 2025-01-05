import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapFileSectionIntoMemoryPrivateMode {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "/home/yan/github/BlogTests/greeting";
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw"); FileChannel channel = raf.getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.PRIVATE, 0, 5);
            display(buffer);

            buffer.clear();
            buffer.put("nihao".getBytes());

            buffer.flip();
            display(buffer);
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

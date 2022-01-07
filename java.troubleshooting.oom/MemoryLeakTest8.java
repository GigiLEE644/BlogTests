import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * -Xms10m -Xmx10m
 */
public class MemoryLeakTest8 {
    public static void main(String[] args) throws InterruptedException, IOException {
        ByteBuffer.allocateDirect(1024 * 1024 * 11);
    }
}

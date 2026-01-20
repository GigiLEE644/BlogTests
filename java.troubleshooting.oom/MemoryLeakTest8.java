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
/**
   Output:
     Exception in thread "main" java.lang.OutOfMemoryError: Cannot reserve 11534336 bytes of direct buffer memory (allocated: 0, limit: 10485760)
        at java.base/java.nio.Bits.reserveMemory(Bits.java:178)
        at java.base/java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:111)
        at java.base/java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:360)
        at MemoryLeakTest8.main(MemoryLeakTest8.java:9)
 */
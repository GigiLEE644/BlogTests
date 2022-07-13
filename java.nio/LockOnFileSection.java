import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class LockOnFileSection {
    public static void main(String[] args) {
        final String path = "/home/yan/github/BlogTests/greeting";

        new Thread(() -> {
            lock(path, () -> {
                sleep(5);
            });
        }).start();

        sleep(1);

        // below throw OverlappingFileLockException since the file section has been
        // locked by another thread
        lock(path, () -> {
        });
    }

    private static void lock(String path, Runnable run) {
        try (RandomAccessFile reader = new RandomAccessFile(path, "rw");
                FileChannel channel = reader.getChannel();
                FileLock fileLock = channel.tryLock(0, 5, Boolean.FALSE)) {
            run.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

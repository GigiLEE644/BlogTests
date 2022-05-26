import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderWriterTest {
    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();

        writer.connect(reader);
        //reader.connect(writer);

        Thread t1 = new Thread(() -> {
            try {
                writer.write("hello world");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    writer.close();
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });

        t1.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            e.printStackTrace();
        });

        Thread t2 = new Thread(() -> {
            try {
                char[] chs = new char[1024];
                reader.read(chs);
                System.out.println(chs);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            } finally {
                try {
                    reader.close();
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });

        t2.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            e.printStackTrace();
        });

        t1.start();
        t2.start();
    }
}

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream(pis);

        Thread t1 = new Thread(() -> {
            try {
                pos.write("hello world".getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    pos.close();
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
                byte[] bytes = pis.readAllBytes();

                System.out.println(new String(bytes));
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            } finally {
                try {
                    pis.close();
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

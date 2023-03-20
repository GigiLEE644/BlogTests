import java.time.Instant;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Runnable sender = () -> {
            try {
                String data = "Hello";
                logWithTimeStamp("Thread 1 sending data ...");
                queue.put(data);
                logWithTimeStamp("Thread 1 sent data : " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable receiver = () -> {
            try {
                logWithTimeStamp("Thread 2 receiving data ...");
                String data = queue.take();
                logWithTimeStamp("Thread 2 received data : " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        int waiting = 5;

        Thread s1 = new Thread(sender);
        Thread r1 = new Thread(receiver);

        s1.start();
        TimeUnit.SECONDS.sleep(waiting);
        r1.start();

        s1.join();
        r1.join();

        System.out.println();

        Thread s2 = new Thread(sender);
        Thread r2 = new Thread(receiver);

        r2.start();
        TimeUnit.SECONDS.sleep(waiting);
        s2.start();

        s2.join();
        r2.join();
    }

    private static void logWithTimeStamp(String message) {
        System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : " + message);
    }
}

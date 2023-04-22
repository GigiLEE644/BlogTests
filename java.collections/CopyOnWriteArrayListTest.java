import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> counter = new CopyOnWriteArrayList<>(new Integer[] { 0 });

        AtomicBoolean writen = new AtomicBoolean(false);

        Runnable reader = () -> {
            while (!writen.get()) {
                System.out.println(
                        "[" + Instant.now() + "] " + Thread.currentThread().getName() + " : " + counter.get(0));
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writer = () -> {
            counter.set(0, counter.get(0) + 1);
            System.out.println();
            System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : " + counter.get(0));
            System.out.println();
        };

        int nReader = 10;
        int nWriter = 3;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < nReader; i++) {
            Thread thread = new Thread(reader, "Reader_" + i);

            thread.start();

            threads.add(thread);
        }

        for (int j = 0; j < nWriter; j++) {
            Thread thread = new Thread(writer, "Writer_" + j);

            TimeUnit.SECONDS.sleep(1);

            thread.start();

            threads.add(thread);
        }

        TimeUnit.SECONDS.sleep(1);

        writen.set(true);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
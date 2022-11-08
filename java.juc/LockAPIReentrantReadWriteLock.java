import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockAPIReentrantReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();

        Runnable read = () -> {
            container.read();
        };

        Runnable writeEven = () -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    container.write(i);
                }
            }
        };

        Runnable writeOdd = () -> {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    container.write(i);
                }
            }
        };

        Thread reader1 = new Thread(read);
        Thread reader2 = new Thread(read);
        Thread reader3 = new Thread(read);
        Thread reader4 = new Thread(read);
        Thread reader5 = new Thread(read);
        Thread writer1 = new Thread(writeOdd);
        Thread writer2 = new Thread(writeEven);

        writer1.start();
        writer2.start();

        TimeUnit.MILLISECONDS.sleep(100);

        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();

        writer1.join();
        writer2.join();
        reader1.join();
        reader2.join();
        reader3.join();
        reader4.join();
        reader5.join();
    }

    private static class Container {
        private List<Integer> list;
        private ReadWriteLock lock;

        Container() {
            this.list = new ArrayList<>();
            this.lock = new ReentrantReadWriteLock();
        }

        void write(int element) {
            try {
                this.lock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " write :");
                System.out.println(element);
                this.list.add(element);
            } finally {
                this.lock.writeLock().unlock();
            }
        }

        void read() {
            try {
                this.lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " read :");
                System.out.println(Arrays.toString(this.list.toArray()));
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class LockAPIStampedLock2 {
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
        private StampedLock lock;

        Container() {
            this.list = new ArrayList<>();
            this.lock = new StampedLock();
        }

        void write(int element) {
            long stamp = this.lock.writeLock();
            try {
                System.out.println(Thread.currentThread().getName() + " write :");
                System.out.println(element);
                this.list.add(element);
            } finally {
                this.lock.unlockWrite(stamp);
            }
        }

        void read() {
            long stamp = this.lock.tryOptimisticRead();

            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    System.out.println(Thread.currentThread().getName() + " read :");
                    System.out.println(Arrays.toString(this.list.toArray()));
                } finally {
                    this.lock.unlockRead(stamp);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " optimistic read :");
                System.out.println(Arrays.toString(this.list.toArray()));
            }
        }
    }
}

/*
 StampedLock is an alternative to using a ReadWriteLock (implemented by ReentrantReadWriteLock). The main differences between StampedLock and ReentrantReadWriteLock are that:

StampedLocks allow optimistic locking for read operations
ReentrantLocks are reentrant (StampedLocks are not)
So if you have a scenario where you have contention (otherwise you may as well use synchronized or a simple Lock) and more readers than writers, using a StampedLock can significantly improve performance.
 */
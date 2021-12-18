import java.util.concurrent.TimeUnit;

public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        synchronized (lock2) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (lock1) {
                System.out.println("never enter here");
            }
        }

        Thread t = new Thread() {
            @Override
            public void run() {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("never enter here");
                    }
                }
            }
        };

        t.start();
    }
}
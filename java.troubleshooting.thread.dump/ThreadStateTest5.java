import java.util.concurrent.locks.LockSupport;

public class ThreadStateTest5 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            LockSupport.parkNanos(1_000_000_000);
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(100);
        System.out.println(t.getState());
        System.exit(0);
    }
}
/*
 * Output:
 *   TIMED_WAITING
 */
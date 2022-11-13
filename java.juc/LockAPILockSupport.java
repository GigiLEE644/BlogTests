import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockAPILockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 will be parked");
            LockSupport.park("t1's blocker");
            System.out.println("Thread 1 after being parked");
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 will be parked");
            LockSupport.park("t2's blocker");
            System.out.println("Thread 2 after being parked");
        });

        t2.start();

        TimeUnit.SECONDS.sleep(1);

        Object blocker1 = LockSupport.getBlocker(t1);

        System.out.println("Blocker 1 is " + blocker1);

        Object blocker2 = LockSupport.getBlocker(t2);

        System.out.println("Blocker 2 is " + blocker2);

        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
    }
}

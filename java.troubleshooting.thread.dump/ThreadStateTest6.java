import java.util.concurrent.locks.LockSupport;

public class ThreadStateTest6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getState());
        System.exit(0);
    }
}
/*
 * Output:
 *   TERMINATED
 */
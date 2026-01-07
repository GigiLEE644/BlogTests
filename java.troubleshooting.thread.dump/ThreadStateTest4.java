import java.util.concurrent.locks.LockSupport;

public class ThreadStateTest4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            LockSupport.park();
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getState());
        System.exit(0);
    }
}
/*
Output:
    WAITING
 */
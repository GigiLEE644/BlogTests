import java.util.concurrent.locks.LockSupport;

public class LockAPILockSupport2 {
    public static void main(String[] args) throws InterruptedException {
        // get a permit
        LockSupport.unpark(Thread.currentThread());
        // consume a permit
        LockSupport.park();
        System.out.println("Main thread exiting");
    }
}

/*
 Output :
    Main thread exiting
 */
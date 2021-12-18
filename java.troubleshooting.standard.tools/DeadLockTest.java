public class DeadLockTest {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {

                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock1) {
                    synchronized (lock2) {

                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
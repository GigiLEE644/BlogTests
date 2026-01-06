public class ThreadStateTest3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            synchronized (ThreadStateTest3.class) {
                while (true) {

                }
            }
        };

        Thread t1 = new Thread(r);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(r);
        t2.start();
        Thread.sleep(1000);
        System.out.println(t2.getState());
        System.exit(0);
    }
}
/*
Output:
    BLOCKED
 */
import java.util.concurrent.TimeUnit;

public class VolatileExample {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (!stop) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
        };

        Thread t = new Thread(r);

        t.start();

        int n = 1;

        TimeUnit.MILLISECONDS.sleep(n);

        stop = true;

        System.out.println("Thread has been signaled to stop after waiting for " + n + " milliseconds.");
    }
}

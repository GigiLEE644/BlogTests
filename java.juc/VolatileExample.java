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

        TimeUnit.SECONDS.sleep(1);

        stop = true;
    }
}

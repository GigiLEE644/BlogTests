import java.util.concurrent.TimeUnit;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            int count = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + count++);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("main thread finishes, so daemon thread is also forced to terminate");
    }
}

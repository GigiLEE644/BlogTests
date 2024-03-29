import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AssignTaskByScheduleWithFixedDelay {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);

        try {
            AtomicInteger counter = new AtomicInteger();

            ScheduledFuture<?> future = es.scheduleWithFixedDelay(
                    () -> {
                        int current = counter.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() +
                                " : increases counter by 1 at : "
                                + new Timestamp(System.currentTimeMillis())
                                + " , current counter value = " + current);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    },
                    3,
                    2,
                    TimeUnit.SECONDS);

            System.out.println("Task has been assigned to pool at : " + new Timestamp(System.currentTimeMillis()));

            while (true) {
                int current = counter.get();
                if (current >= 5) {
                    System.out.println("Count >= 5, cancel the scheduledFuture!");
                    future.cancel(false);
                    break;
                } else {
                    Thread.sleep(1000);
                }
            }
        } finally {
            es.shutdown();
        }
    }
}
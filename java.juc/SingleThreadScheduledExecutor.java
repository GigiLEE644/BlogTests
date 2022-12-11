import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;
                es.schedule(() -> System.out.println(
                        Thread.currentThread().getName()
                                + " : executing task "
                                + taskNumber
                                + " at : "
                                + new Timestamp(System.currentTimeMillis())),
                        3, TimeUnit.SECONDS);
            }
            System.out.println(
                    "All the tasks have been assigned to pool at : " + new Timestamp(System.currentTimeMillis()));
        } finally {
            es.shutdown();
        }
    }
}

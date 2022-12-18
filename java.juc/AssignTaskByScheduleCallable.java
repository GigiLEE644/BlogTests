import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AssignTaskByScheduleCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);

        try {
            List<ScheduledFuture<String>> futures = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                futures.add(es.schedule(
                        () -> Thread.currentThread().getName() + " : executing task " + taskNumber + " at : "
                                + new Timestamp(System.currentTimeMillis()),
                        3,
                        TimeUnit.SECONDS));
            }

            System.out.println(
                    "All the tasks have been assigned to pool at : " + new Timestamp(System.currentTimeMillis()));

            for (int i = 0; i < futures.size(); i++) {
                System.out.println("Remaining delay for task " + i + " = " + futures.get(i).getDelay(TimeUnit.SECONDS));
            }

            for (int i = 0; i < futures.size(); i++) {
                System.out.println(futures.get(i).get());
            }
        } finally {
            es.shutdown();
        }
    }
}
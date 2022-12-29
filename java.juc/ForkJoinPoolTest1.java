import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool(3);

        try {
            List<ForkJoinTask<String>> tasks = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                tasks.add(pool.submit(() -> {
                    TimeUnit.SECONDS.sleep(1);
                    return Thread.currentThread().getName() + " : executing task " + taskNumber;
                }));
            }

            for (ForkJoinTask<String> task : tasks) {
                System.out.println(task.get());
            }
        } finally {
            pool.shutdown();
        }
    }
}

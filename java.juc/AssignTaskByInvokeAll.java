import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AssignTaskByInvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                tasks.add(() -> Thread.currentThread().getName() + " : executing task " + taskNumber);
            }

            List<Future<String>> futures = es.invokeAll(tasks);

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } finally {
            es.shutdown();
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletionServiceTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        ExecutorCompletionService<String> ecs = new ExecutorCompletionService<>(es);

        try {
            List<Future<String>> futures = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                futures.add(ecs.submit(
                        () -> {
                            TimeUnit.SECONDS.sleep(taskNumber);
                            return Thread.currentThread().getName() + " : executing task " + taskNumber;
                        }));
            }

            for (int i = futures.size() - 1; i >= 0; i--) {
                System.out.println(ecs.take().get());
            }
        } finally {
            es.shutdown();
        }
    }
}
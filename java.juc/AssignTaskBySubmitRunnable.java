import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AssignTaskBySubmitRunnable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            List<Future> futures = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                futures.add(es.submit(
                        () -> System.out.println(
                                Thread.currentThread().getName() + " : executing task " + taskNumber)));
            }

            for (int i = 0; i < futures.size(); i++) {
                System.out.println(futures.get(i).get());
            }
        } finally {
            es.shutdown();
        }
    }
}
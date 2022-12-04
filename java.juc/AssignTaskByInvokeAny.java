import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AssignTaskByInvokeAny {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;

                tasks.add(() -> {
                    String result = Thread.currentThread().getName() + " : executing task " + taskNumber;
                    System.out.println(result);
                    return "The returned result by invokeAny is : " + result;
                });
            }

            String executed = es.invokeAny(tasks);

            System.out.println(executed);
        } finally {
            es.shutdown();
        }
    }
}
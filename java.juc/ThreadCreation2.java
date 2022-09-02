import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreation2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> c = new Callable<>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        };

        FutureTask<String> task = new FutureTask<>(c);

        Thread t = new Thread(task, "Thread1");

        t.start();

        System.out.println(task.get());
    }
}

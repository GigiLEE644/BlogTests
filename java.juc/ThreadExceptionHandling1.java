import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExceptionHandling1 {
    public static void main(String[] args) {
        Callable<Void> c = () -> {
            throw new RuntimeException("exception in callable");
        };

        FutureTask<Void> f = new FutureTask<>(c);

        Thread t = new Thread(f);

        t.start();

        try {
            f.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("exception caught in thread " + t.getName() + " : " + e.getCause().getMessage());
        }
    }
}

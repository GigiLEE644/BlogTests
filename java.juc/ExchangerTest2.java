import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest2 {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        int nThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        try {
            for (int i = 0; i < nThreads; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String name = Thread.currentThread().getName();
                            String partner = exchanger.exchange(name);
                            System.out.println("I am thread " + name + " and my partner of exchange is " + partner);
                        } catch (InterruptedException ie) {
                        }
                    }
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}
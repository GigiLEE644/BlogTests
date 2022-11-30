import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 3;
        long keepAliveTime = 10l;
        TimeUnit unit = TimeUnit.SECONDS;
        int queueSize = 5;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(queueSize);
        ThreadFactory threadFactory = new ThreadFactory() {
            int threadNumber = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "MyThread-" + (threadNumber++));
            }
        };
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ExecutorService es = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                threadFactory, handler);

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;
                es.execute(
                        () -> System.out.println(
                                Thread.currentThread().getName() + " : executing task " + taskNumber));
            }
        } finally {
            es.shutdown();
        }
    }
}

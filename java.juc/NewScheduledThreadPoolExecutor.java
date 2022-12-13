import java.sql.Timestamp;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 2;

        ThreadFactory threadFactory = new ThreadFactory() {
            int threadNumber = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "MyThread-" + (threadNumber++));
            }
        };

        RejectedExecutionHandler handler = new ScheduledThreadPoolExecutor.CallerRunsPolicy();

        ScheduledExecutorService es = new ScheduledThreadPoolExecutor(corePoolSize, threadFactory, handler);

        try {
            for (int i = 0; i < 10; i++) {
                final Integer taskNumber = i;
                es.schedule(() -> System.out.println(
                        Thread.currentThread().getName()
                                + " : executing task "
                                + taskNumber
                                + " at : "
                                + new Timestamp(System.currentTimeMillis())),
                        3, TimeUnit.SECONDS);
            }
            System.out.println(
                    "All the tasks have been assigned to pool at : " + new Timestamp(System.currentTimeMillis()));
        } finally {
            es.shutdown();
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * -Xms10m -Xmx10m
 */
public class MemoryLeakTest7 {
    public static ThreadLocal<List<byte[]>> tl = new ThreadLocal<>() {
        @Override
        protected List<byte[]> initialValue() {
            return new ArrayList<>();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 2;
        ExecutorService pool = new MyThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadFactory() {
                    private int tCount = 1;

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("T" + this.tCount++);
                        return t;
                    }
                });
        while (true) {
            pool.submit(new MyRunnable());
            Thread.sleep(10);
        }
    }

    private static class MyThreadPoolExecutor extends ThreadPoolExecutor {
        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            // uncomment below will clean up thread local every time
            // tl.remove();
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            List<byte[]> list = tl.get();

            list.add(new byte[1024 * 512]);

            // size of list keep increasing
            System.out.println(Thread.currentThread().getName() + " : " + list.size());
        }
    }
}

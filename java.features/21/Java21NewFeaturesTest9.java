import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java21NewFeaturesTest9 {

        public static void main(String[] args) throws InterruptedException {
                ExecutorService e = Executors.newVirtualThreadPerTaskExecutor();

                for (int i = 0; i < 10; i++) {
                        e.submit(() -> {
                                System.out.println("Running task in thread : " + Thread.currentThread());
                        });
                }

                e.shutdown();

                Thread.currentThread().join();
        }
}
/**
 * Output:
        Running task in thread : VirtualThread[#29]/runnable@ForkJoinPool-1-worker-4
        Running task in thread : VirtualThread[#34]/runnable@ForkJoinPool-1-worker-6
        Running task in thread : VirtualThread[#32]/runnable@ForkJoinPool-1-worker-2
        Running task in thread : VirtualThread[#24]/runnable@ForkJoinPool-1-worker-1
        Running task in thread : VirtualThread[#26]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#36]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#37]/runnable@ForkJoinPool-1-worker-1
        Running task in thread : VirtualThread[#38]/runnable@ForkJoinPool-1-worker-6
        Running task in thread : VirtualThread[#39]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#35]/runnable@ForkJoinPool-1-worker-5
 */
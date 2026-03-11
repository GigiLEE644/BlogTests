import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.UUID;

public class Java21NewFeaturesTest10 {

        public static void main(String[] args) throws InterruptedException {
                ThreadFactory base = Thread.ofVirtual().factory();

                ThreadFactory f = r -> {
                        Thread t = base.newThread(r);
                        t.setName("app-" + UUID.randomUUID());
                        return t;
                };

                ExecutorService e = Executors.newFixedThreadPool(2, f);

                for (int i = 0; i < 10; i++) {
                        e.submit(() -> {
                                System.out.println("Running task in thread : "
                                                + Thread.currentThread());
                        });
                }

                e.shutdown();

                Thread.currentThread().join();
        }
}
/* Output:
        Running task in thread : VirtualThread[#26,app-4efb38de-2044-4e60-9509-d3ca346b1975]/runnable@ForkJoinPool-1-worker-2
        Running task in thread : VirtualThread[#26,app-4efb38de-2044-4e60-9509-d3ca346b1975]/runnable@ForkJoinPool-1-worker-2
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-1
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#24,app-264d5360-13bd-4566-b4c0-942db27dc027]/runnable@ForkJoinPool-1-worker-3
        Running task in thread : VirtualThread[#26,app-4efb38de-2044-4e60-9509-d3ca346b1975]/runnable@ForkJoinPool-1-worker-2
 */
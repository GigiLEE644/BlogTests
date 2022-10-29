import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPIReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            service.submit(counter::inc);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("sum = " + counter.sum);
    }

    private static class Counter {
        private int sum = 0;

        private Lock lock = new ReentrantLock();

        void inc() {
            this.lock.lock();
            try {
                this.sum++;
            } finally {
                this.lock.unlock();
            }
        }
    }
}

/*
Output :
    yan@ubuntu:~/github/BlogTests$  cd /home/yan/github/BlogTests ; /usr/bin/env /home/yan/Apps/jdk-17.0.3.1/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/yan/.config/Code/User/workspaceStorage/cb6e219fa798ac2300babcaaca8a9a47/redhat.java/jdt_ws/BlogTests_e0c01ebd/bin LockAPIReentrantLock 
    sum = 1000
    yan@ubuntu:~/github/BlogTests$ 
 */
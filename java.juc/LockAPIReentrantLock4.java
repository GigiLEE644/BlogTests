import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPIReentrantLock4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Container container = new Container(5);

        for (int i = 0; i < 10; i++) {
            Integer element = i;
            service.submit(() -> container.push(element));
        }

        for (int i = 0; i < 9; i++) {
            service.submit(container::pop);
        }

        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);

        container.display();
    }

    private static class Container {
        private int capacity;
        private List<Integer> list;
        private Lock lock;
        private Condition empty;
        private Condition full;

        Container(int capacity) {
            this.capacity = capacity;
            this.list = new ArrayList<>(capacity);
            this.lock = new ReentrantLock();
            this.empty = this.lock.newCondition();
            this.full = this.lock.newCondition();
        }

        void push(int element) {
            this.lock.lock();

            while (this.list.size() >= this.capacity) {
                try {
                    this.full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println(Thread.currentThread().getName() + " push " + element);
                this.list.add(element);
            } finally {
                this.empty.signalAll();
                this.lock.unlock();
            }
        }

        int pop() {
            this.lock.lock();

            while (this.list.size() <= 0) {
                try {
                    this.empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println(Thread.currentThread().getName() + " pop");
                return this.list.remove(this.list.size() - 1);
            } finally {
                this.full.signalAll();
                this.lock.unlock();
            }

        }

        void display() {
            for (int element : this.list) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
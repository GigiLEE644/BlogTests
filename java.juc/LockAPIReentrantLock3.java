import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockAPIReentrantLock3 {
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

        Container(int capacity) {
            this.capacity = capacity;
            this.list = new ArrayList<>(capacity);
        }

        void push(int element) {
            synchronized (this.list) {
                while (this.list.size() >= this.capacity) {
                    try {
                        this.list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    System.out.println(Thread.currentThread().getName() + " push " + element);
                    this.list.add(element);
                } finally {
                    this.list.notifyAll();
                }
            }
        }

        int pop() {
            synchronized (this.list) {
                while (this.list.size() <= 0) {
                    try {
                        this.list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    System.out.println(Thread.currentThread().getName() + " pop");
                    return this.list.remove(this.list.size() - 1);
                } finally {
                    this.list.notifyAll();
                }
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
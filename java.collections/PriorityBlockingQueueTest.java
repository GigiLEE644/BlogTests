import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.add(2);
        queue.add(1);
        queue.add(3);

        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " : taking from queue ...");
                int element = queue.take();
                System.out.println(element);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

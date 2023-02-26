import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest1 {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                String data = "Hello";
                System.out.println("Thread 1 sending data : " + data);
                queue.put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Thread 2 receives data : " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

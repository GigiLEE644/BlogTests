import java.util.concurrent.Exchanger;

public class ExchangerTest1 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable taskA = () -> {
            try {
                String message = exchanger.exchange("from A");
                System.out.println(Thread.currentThread().getName() + " : " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        Runnable taskB = () -> {
            try {
                String message = exchanger.exchange("from B");
                System.out.println(Thread.currentThread().getName() + " : " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        new Thread(taskA, "A").start();
        new Thread(taskB, "B").start();
    }
}
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MethodOfThreadClass6 {
    public static void main(String[] args) {
        Container container = new Container(5);

        Runnable p = () -> {
            for (int i = 0; i < 6; i++) {
                container.add();
            }
        };

        Runnable c = () -> {
            for (int i = 0; i < 5; i++) {
                container.remove();
            }
        };

        Thread producer = new Thread(p);
        Thread consumer = new Thread(c);

        producer.setDaemon(true);
        consumer.setDaemon(true);

        producer.start();
        consumer.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        container.display();
    }

    private static class Container {
        private int[] content;
        private int index;

        Container(int capacity) {
            this.content = new int[capacity];
            this.index = 0;
        }

        synchronized void add() {
            while (this.content[this.content.length - 1] == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.content[this.index++] = 1;

            notify();
        }

        synchronized void remove() {
            while (this.content[0] == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.content[--this.index] = 0;

            notify();
        }

        void display() {
            IntStream.range(0, this.content.length).forEach(index -> {
                System.out.print(this.content[index]);

                if (index == this.content.length - 1) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            });
        }
    }
}

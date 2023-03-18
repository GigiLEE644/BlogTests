import java.time.Instant;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        delayQueue.put(new DelayedTask("Task 1", 5, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task 2", 10, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task 3", 15, TimeUnit.SECONDS));

        System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : start");
        while (!delayQueue.isEmpty()) {
            System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : taking ...");
            DelayedTask task = delayQueue.take();
            System.out.println("[" + Instant.now() + "] " + Thread.currentThread().getName() + " : "
                    + task.getName() + " taken");
        }
    }

    static class DelayedTask implements Delayed {
        private final String name;
        private final long endTime;

        public DelayedTask(String name, long delay, TimeUnit unit) {
            this.name = name;
            this.endTime = System.currentTimeMillis() + unit.toMillis(delay);
        }

        public String getName() {
            return name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remainingTime = endTime - System.currentTimeMillis();
            return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(this.endTime, ((DelayedTask) other).endTime);
        }
    }
}

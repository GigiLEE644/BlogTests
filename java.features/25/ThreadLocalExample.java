public class ThreadLocalExample {
    // Each thread gets its own Integer value
    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocalValue.set((int) (Math.random() * 100));
            System.out.println(Thread.currentThread().getName() + ": " + threadLocalValue.get());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
/*
 * Output: Thread-1: 42
 *         Thread-2: 87
 */
public class ScopedValueExample {
    static final ScopedValue<Integer> VALUE = ScopedValue.newInstance();

    void main() {
        Runnable task = () -> {
            int randomValue = (int) (Math.random() * 100);
            ScopedValue.where(VALUE, randomValue).run(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + VALUE.get());
            });
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
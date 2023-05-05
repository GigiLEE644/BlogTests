import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentSkipListSetTest {
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new ConcurrentSkipListSet<>(Collections.reverseOrder());

        set.add(3);
        set.add(3);
        set.add(2);
        set.add(2);
        set.add(1);
        set.add(1);
        set.add(5);
        set.add(5);
        set.add(4);
        set.add(4);

        set.spliterator().forEachRemaining(System.out::println);

        set.clear();

        ExecutorService es = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10000; i++) {
                final Integer element = Integer.valueOf(i);
                es.execute(() -> {
                    set.add(element);
                });
            }
        } finally {
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        }

        System.out.println("Set size = " + set.size());
    }
}
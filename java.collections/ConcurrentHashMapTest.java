import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // HashMap<String, Integer> map = new HashMap<>();

        String key = "test";

        map.put(key, 0);

        ExecutorService es = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10000; i++) {
                es.execute(() -> {
                    map.computeIfPresent(
                            key,
                            (k, v) -> v + 1);
                });
            }
        } finally {
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        }

        int cnt = map.get(key);

        System.out.println(cnt);
    }
}

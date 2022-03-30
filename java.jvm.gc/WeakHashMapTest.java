import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Key, String> map = new HashMap<>();
        test(map);

        map = new WeakHashMap<>();
        test(map);
    }

    private static void test(Map<Key, String> map) throws InterruptedException {
        Key key = new Key();

        map.put(key, "hello world");

        key = null;

        System.gc();

        Thread.sleep(3000);

        System.out.println("After gc, element number in map is :");

        System.out.println(map.size());
    }

    private static class Key {

    }
}

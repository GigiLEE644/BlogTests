import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<String, String>();

        map.put("3", "World");
        map.put("2", "Hello");
        map.put("1", "Hi!");

        System.out.println("Initial Map : " + map);

        System.out.println();

        Iterator<String> it = map.descendingKeySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println();

        System.out.println("firstEntry: " + map.firstEntry());

        System.out.println("lastEntry: " + map.lastEntry());
    }
}

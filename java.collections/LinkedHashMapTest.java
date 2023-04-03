import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        // Insertion Order
        // Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "one");

        System.out.println(map.keySet().toString());

        System.out.println();

        // Access Order
        map = new LinkedHashMap<>(16, .75f, true);

        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "one");

        Set<Integer> keys = map.keySet();
        System.out.println(keys.toString());

        map.get(4);
        System.out.println(keys.toString());

        map.get(1);
        System.out.println(keys.toString());

        map.get(3);
        System.out.println(keys.toString());
    }
}

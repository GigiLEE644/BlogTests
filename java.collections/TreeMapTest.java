import java.util.Map.Entry;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, String> fruits = new TreeMap<>();

        fruits.put(2, "pear");
        fruits.put(1, "apple");
        fruits.put(4, "banane");
        fruits.put(5, "melon");
        fruits.put(3, "strawberry");

        Iterator<Entry<Integer, String>> it = fruits.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, String> fruit = it.next();

            System.out.println(fruit.getKey() + " : " + fruit.getValue());
        }

        System.out.println();

        fruits = new TreeMap<>(Collections.reverseOrder());

        fruits.put(2, "pear");
        fruits.put(1, "apple");
        fruits.put(4, "banane");
        fruits.put(5, "melon");
        fruits.put(3, "strawberry");

        for (int id : fruits.keySet()) {
            System.out.println(id + " : " + fruits.get(id));
        }
    }
}

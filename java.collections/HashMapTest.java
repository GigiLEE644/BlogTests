import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> fruitPrices = new HashMap<>();

        fruitPrices.put("apple", 2);
        fruitPrices.put("pear", 9);
        fruitPrices.put("pineapple", 6);

        fruitPrices.put("orange", null);
        fruitPrices.put(null, 0);

        Iterator<Entry<String, Integer>> it = fruitPrices.entrySet().iterator();

        while (it.hasNext()) {
            Entry<String, Integer> fruit = it.next();

            System.out.println(fruit.getKey() + " : " + fruit.getValue());
        }

        System.out.println();

        for (String fruit : fruitPrices.keySet()) {
            Integer price = fruitPrices.get(fruit);

            System.out.println(fruit + " : " + price);
        }
    }
}

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Iterator;

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<String, Integer> fruitPrices = new Hashtable<>();

        fruitPrices.put("apple", 2);
        fruitPrices.put("pear", 9);
        fruitPrices.put("pineapple", 6);

        try {
            fruitPrices.put("orange", null);
        } catch (NullPointerException e) {
            System.out.println("value can not be null");
        }

        try {
            fruitPrices.put(null, 0);
        } catch (NullPointerException e) {
            System.out.println("key can not be null");
        }

        Iterator<Entry<String, Integer>> it = fruitPrices.entrySet().iterator();

        while (it.hasNext()) {
            Entry<String, Integer> fruit = it.next();

            System.out.println(fruit.getKey() + " : " + fruit.getValue());
        }
    }
}

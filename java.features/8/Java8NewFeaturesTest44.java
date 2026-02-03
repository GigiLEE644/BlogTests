import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest44 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        display(Stream.of(nums).collect(
                Collectors.collectingAndThen(Collectors.toMap(i -> i, i -> i * 2), m -> {
                    if (m instanceof HashMap) {
                        Map<Integer, Integer> mm = (HashMap<Integer, Integer>) m;

                        Set<Integer> keys = mm.keySet();

                        for (Integer key : keys) {
                            mm.put(key, mm.get(key) / 2);
                        }
                    }
                    return m;
                })));
    }

    private static void display(Map<Integer, Integer> m) {
        m.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }
}
/**
 * Output:
        key = 1
        value = 1
        key = 2
        value = 2
        key = 3
        value = 3
        key = 4
        value = 4
 */
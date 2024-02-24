import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest43 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4, 2 };

        display(Stream.of(nums).collect(Collectors.toMap(k -> k, v -> v * 2, (v1, v2) -> {
            System.out.println("v1 = " + v1);
            System.out.println("v2 = " + v2);
            System.out.println();
            return v1;
        })));

        System.out.println();

        display(Stream.of(nums).collect(Collectors.toMap(k -> k, v -> v * 2)));
    }

    private static void display(Map<Integer, Integer> m) {
        m.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }
}

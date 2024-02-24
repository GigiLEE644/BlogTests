import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest42 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        display(Stream.of(nums).collect(Collectors.toMap(k -> k, v -> v * 2)));

        System.out.println();

        display(Stream.of(nums).collect(Collectors.toMap(Function.identity(), v -> v * 2)));
    }

    private static void display(Map<Integer, Integer> m) {
        m.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }
}

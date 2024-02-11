import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest43 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4, 2 };

        display(Stream.of(nums).collect(Collectors.toMap(i -> i, i -> i * 2, (i1, i2) -> i1)));

        System.out.println();

        display(Stream.of(nums).collect(Collectors.toMap(i -> i, i -> i * 2)));
    }

    private static void display(Map<Integer, Integer> m) {
        m.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }
}

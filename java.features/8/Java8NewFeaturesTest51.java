import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest51 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4, 4, 4, 4, 3, 3, 2 };

        Stream<Integer> s = Stream.of(nums);

        Map<Integer, Set<Integer>> m = s
                .collect(Collectors.groupingBy(i -> i, Collectors.mapping(i -> 2 * i, Collectors.toSet())));

        for (Map.Entry<Integer, Set<Integer>> e : m.entrySet()) {
            System.out.println("key = " + e.getKey() + " value = " + e.getValue());
        }
    }
}

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest49 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4, 3, 4, 3, 4, 4 };

        Stream<Integer> s = Stream.of(nums);

        Map<Integer, List<Integer>> m = s.collect(Collectors.groupingBy(i -> i, Collectors.toList()));

        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
            System.out.println("key = " + e.getKey() + " value = " + e.getValue());
        }
    }
}

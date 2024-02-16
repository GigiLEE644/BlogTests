import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest50 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        Stream<Integer> s = Stream.of(nums);

        Map<Boolean, List<Integer>> m = s.collect(Collectors.partitioningBy(i -> i % 2 == 0));

        for (Map.Entry<Boolean, List<Integer>> e : m.entrySet()) {
            System.out.println("key = " + e.getKey() + " value = " + e.getValue());
        }
    }
}

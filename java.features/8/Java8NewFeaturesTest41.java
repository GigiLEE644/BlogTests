import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest41 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 4, 2, 2, 4, 3, 1 };

        List<Integer> l = Stream.of(nums).collect(Collectors.toList());

        l.forEach(System.out::println);

        System.out.println();

        Set<Integer> s = Stream.of(nums).collect(Collectors.toSet());

        s.forEach(System.out::println);

        System.out.println();

        TreeSet<Integer> ts = Stream.of(nums).collect(Collectors.toCollection(TreeSet::new));

        ts.forEach(System.out::println);
    }
}

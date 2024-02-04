import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest32 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2, 2, 3 };

        Stream<Integer> s = Stream.of(arr);

        Set<Integer> set = s.collect(Collectors.toSet());

        set.forEach(System.out::println);
    }
}

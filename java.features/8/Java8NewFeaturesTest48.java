import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest48 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        Optional<Integer> max = Stream.of(nums).collect(Collectors.maxBy((n1, n2) -> n1 - n2));

        System.out.println("max = " + max.get());

        Optional<Integer> min = Stream.of(nums).collect(Collectors.maxBy((n1, n2) -> n2 - n1));

        System.out.println("min = " + min.get());
    }
}
